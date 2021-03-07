package com.example.demo.repository.impl;

import java.net.http.HttpResponse;

abstract class CommonRepositoryImpl {
    boolean isNotSuccessful(HttpResponse response) {
        return response.statusCode() / 100 != 2;
    }
}
