package edu.fra.uas.gatewayservice.model;

import org.springframework.http.HttpStatus;

public class ApiError  implements java.io.Serializable{
private HttpStatus status;
    private String message;

    public ApiError(){
    }
    
    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMesssage(String message) {
        this.message = message;
    }
}
