package com.assignment.backend.dto.response;

import org.springframework.http.HttpStatus;

public class MessageResponse {
    HttpStatus status;
    String message;

    public MessageResponse() {
    }

    public MessageResponse(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
