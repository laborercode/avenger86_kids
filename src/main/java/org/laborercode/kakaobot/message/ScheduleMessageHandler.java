package org.laborercode.kakaobot.message;

import org.laborercode.kakaobot.Message;
import org.laborercode.kakaobot.MessageRequest;
import org.laborercode.kakaobot.MessageResponse;

public class ScheduleMessageHandler implements MessageHandler {

    public String getMessage() {
        return "일정";
    }

    public String getHelp() {
        return "예정되어 있는 일정을 보여줍니다.";
    }

    public MessageResponse handle(MessageRequest request) {
        Message message = new Message();
        message.setText("준비중입니다.");
        MessageResponse mr = new MessageResponse();
        mr.setMessage(message);
        return mr;
    }

}
