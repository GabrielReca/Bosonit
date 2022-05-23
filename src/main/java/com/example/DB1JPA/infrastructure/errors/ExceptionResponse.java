package com.example.DB1JPA.infrastructure.errors;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String mensaje;
    private String httpCodeMessage;

    public ExceptionResponse(Date timestamp, String message,String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.mensaje = message;
        this.httpCodeMessage=httpCodeMessage;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

}
