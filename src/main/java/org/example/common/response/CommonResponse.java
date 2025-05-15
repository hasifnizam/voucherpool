package org.example.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse<T> {
    private int statusCode;
    private String message;
    private T data;

    public CommonResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
