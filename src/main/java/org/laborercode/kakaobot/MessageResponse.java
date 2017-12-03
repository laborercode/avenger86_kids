package org.laborercode.kakaobot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MessageResponse {

    private Message message;
    @JsonInclude(Include.NON_NULL)
    private Keyboard keboard;

    public MessageResponse() {
        
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Keyboard getKeboard() {
        return keboard;
    }

    public void setKeboard(Keyboard keboard) {
        this.keboard = keboard;
    }
}
