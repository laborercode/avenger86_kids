package org.laborercode.kakaobot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
@WebServlet("/message")
public class MessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");

        ObjectMapper mapper = new ObjectMapper();
        MessageRequest post = mapper.readValue(req.getInputStream(), MessageRequest.class);

        if("text".equals(post.getType())) {
            String content = post.getContent();
            if("회비".equals(content)) {
                Message message = new Message();
                message.setText("준비중입니다.");
                MessageResponse mr = new MessageResponse();
                mr.setMessage(message);
                mapper.writeValue(resp.getOutputStream(), mr);
            } else if("도움말".equals(content)) {
                Message message = new Message();
                message.setText("회비 : 현재 모인 회비를 보여줍니다.\n");
                MessageResponse mr = new MessageResponse();
                mr.setMessage(message);
                mapper.writeValue(resp.getOutputStream(), mr);
            }
        }
    }
}
