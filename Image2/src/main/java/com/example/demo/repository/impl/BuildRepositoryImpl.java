package com.example.demo.repository.impl;

import com.example.demo.entity.Build;
import com.example.demo.repository.BuildDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.format;

@Repository
public class BuildRepositoryImpl extends CommonRepositoryImpl
        implements BuildDao {
    private final String endPoint;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public BuildRepositoryImpl(@Value("${restservice.endpoint}") String endPoint
            , HttpClient httpClient, ObjectMapper objectMapper) {
        this.endPoint = endPoint;
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public Build create(Build build) {
        HttpResponse<String> response;
        try {
            response = httpClient.send(getRequest(build)
                    , HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (isNotSuccessful(response)) {
            throw new RuntimeException(format("create:: status code received: %s"
                    , response.statusCode()));
        }
        return build;
    }

    boolean isNotSuccessful(HttpResponse response) {
        return response.statusCode() / 100 != 2;
    }

    private HttpRequest getRequest(Build build) {
        try {
            return HttpRequest.newBuilder().uri(new URI(endPoint))
                    .headers("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper
                            .writeValueAsString(build))).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
