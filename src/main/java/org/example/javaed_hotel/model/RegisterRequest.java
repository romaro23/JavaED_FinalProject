package org.example.javaed_hotel.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}