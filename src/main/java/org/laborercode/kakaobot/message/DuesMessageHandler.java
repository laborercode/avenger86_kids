package org.laborercode.kakaobot.message;

import org.laborercode.kakaobot.Message;
import org.laborercode.kakaobot.MessageRequest;
import org.laborercode.kakaobot.MessageResponse;

public class DuesMessageHandler implements MessageHandler {
    public String getMessage() {
        return "회비";
    }

    public String getHelp() {
        return "현재 모인 회비를 보여줍니다.";
    }

    public MessageResponse handle(MessageRequest request) {
        Message message = new Message();
        message.setText("준비중입니다.");
        MessageResponse mr = new MessageResponse();
        mr.setMessage(message);
        return mr;
    }
}
