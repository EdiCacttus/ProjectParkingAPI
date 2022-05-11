package DTO;

import java.util.HashMap;
import java.util.UUID;

public class HttpResponseDTO <T>{
    private boolean success;
    private T data;

    private String message;




    public HttpResponseDTO(boolean b, T zoneRequestResponse) {

        this.success = success;
        this.data = data;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
