package com.example.usergems.model.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int total;
    private int per_page;
    private int current_page;
    private T data;
}
