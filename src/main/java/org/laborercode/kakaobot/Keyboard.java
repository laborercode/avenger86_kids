package org.laborercode.kakaobot;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Keyboard {

    private String type;
    @JsonInclude(Include.NON_NULL)
    private List<String> button;

    public Keyboard() {
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getButton() {
        return button;
    }

    public void setButton(List<String> button) {
        this.button = button;
    }
}
