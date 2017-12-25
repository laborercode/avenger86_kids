package org.laborercode.kakaobot.message;

import org.laborercode.kakaobot.MessageRequest;
import org.laborercode.kakaobot.MessageResponse;

public interface MessageHandler {

    public String getMessage();
    public String getHelp();
    public MessageResponse handle(MessageRequest request);
}
