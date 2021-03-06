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
public class BuildDaoImpl
        implements BuildDao {
    private final String endPoint;

    @Autowired
    public BuildDaoImpl(@Value("${restservice.endpoint}") String endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public Build create(Build build) {
        HttpResponse<String> response;
        try {
            response = HttpClient.newBuilder().build()
                    .send(getRequest(build), HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (response.statusCode() / 100 != 2) {
            throw new RuntimeException(format("create:: status code received: %s"
                    , response.statusCode()));
        }
        return build;
    }

    private HttpRequest getRequest(Build build) {
        try {
            return HttpRequest.newBuilder().uri(new URI(endPoint))
                    .headers("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper()
                            .writeValueAsString(build))).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
