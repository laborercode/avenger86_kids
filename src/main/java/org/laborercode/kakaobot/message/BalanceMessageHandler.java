package org.laborercode.kakaobot.message;

import java.io.IOException;

import org.laborercode.kakaobot.Message;
import org.laborercode.kakaobot.MessageRequest;
import org.laborercode.kakaobot.MessageResponse;
import org.laborercode.kakaobot.sheetsapi.HistorySheet;

public class BalanceMessageHandler implements MessageHandler {
    public String getMessage() {
        return "잔액";
    }

    public String getHelp() {
        return "현재 모인 회비 잔액을 보여줍니다.";
    }

    public MessageResponse handle(MessageRequest request) {
        Message message = new Message();
        try {
            message.setText("현재 회비 잔액은 " + HistorySheet.getBalance() + "원 입니다.");
        } catch (IOException e) {
            message.setText("처리중 문제가 발생하였습니다. 관리자에게 문의하세요.\n" + e);
        }
        MessageResponse mr = new MessageResponse();
        mr.setMessage(message);
        return mr;
    }
}
