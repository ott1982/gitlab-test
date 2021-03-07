package com.example.demo.repository.impl;

import com.example.demo.repository.TagDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
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
public class TagDaoImpl extends CommonRepositoryImpl
        implements TagDao {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final String endPoint;

    @Autowired
    public TagDaoImpl(HttpClient httpClient, ObjectMapper objectMapper
            , @Value("${gitlab.url}") String endPoint) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
        this.endPoint = endPoint;
    }

    @Override
    public void createTag(String privateToken, String name, String tag) {
        HttpResponse<String> response;
        try {
            response = httpClient.send(getRequest(privateToken, name, tag)
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
        return;
    }

    private HttpRequest getRequest(String privateKey, String name, String tag) {
        try {
            return HttpRequest.newBuilder().uri(new URI(endPoint
                    + format("?project=%s&tag=%s", name, tag)))
                    .header(HttpHeaders.CONTENT_TYPE
                            , MediaType.APPLICATION_JSON.toString())
                    .header("private-key", privateKey)
                    .POST(HttpRequest.BodyPublishers.noBody()).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}