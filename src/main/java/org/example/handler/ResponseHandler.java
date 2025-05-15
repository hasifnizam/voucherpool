package org.example.handler;

import org.example.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static <T> ResponseEntity<CommonResponse<T>> generateResponse(HttpStatus status, String message, T data) {
        CommonResponse<T> response = new CommonResponse<>(status.value(), message, data);
        return new ResponseEntity<>(response, status);
    }
}
