package com.aoinc.w2d1_a_pseudomessaging;

import java.io.Serializable;

public class MessageData implements Serializable {
    private String message;

    public MessageData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
