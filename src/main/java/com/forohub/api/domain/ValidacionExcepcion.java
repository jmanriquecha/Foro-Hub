package com.forohub.api.domain;

public class ValidacionExcepcion extends RuntimeException {
    public ValidacionExcepcion(String mensaje) {
        super(mensaje);
    }
}
