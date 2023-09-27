package com.aiopshackathon.carreservation.carservice.service;

public class CarServiceException extends RuntimeException {

    public CarServiceException(String message) {
        super(message);
    }

    public CarServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
