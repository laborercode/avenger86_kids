package org.laborercode.kakaobot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Message {

    @JsonInclude(Include.NON_NULL)
    private String text;
    @JsonInclude(Include.NON_NULL)
    private Photo photo;
    @JsonInclude(Include.NON_NULL)
    private MessageButton message_button;

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public MessageButton getMessage_button() {
        return message_button;
    }

    public void setMessage_button(MessageButton message_button) {
        this.message_button = message_button;
    }
}
