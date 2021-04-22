package com.mindbowser.grocery.store.management.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor( staticName = "of")
public class Response<T> {

    @NonNull
    private String message;
    private String error;
    @NonNull
    private int code;
    @NonNull
    private String status;
    private T data;

    public Response(String message, int code, String status, T data) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public Response(String message, String error, int code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.error = error;
    }
}
