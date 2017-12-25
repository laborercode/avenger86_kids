package org.laborercode.kakaobot.message;

import org.laborercode.kakaobot.Message;
import org.laborercode.kakaobot.MessageRequest;
import org.laborercode.kakaobot.MessageResponse;

public class AccountMessageHandler implements MessageHandler {

    public String getMessage() {
        return "계좌";
    }

    public String getHelp() {
        return "총무의 계좌를 보여줍니다.";
    }

    public MessageResponse handle(MessageRequest request) {
        Message message = new Message();
        message.setText("카카오뱅크 3333024667407");
        MessageResponse mr = new MessageResponse();
        mr.setMessage(message);
        return mr;
    }

}
