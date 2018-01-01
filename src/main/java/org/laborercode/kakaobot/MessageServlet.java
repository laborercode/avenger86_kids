package org.laborercode.kakaobot;

import java.io.IOException;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.laborercode.kakaobot.message.MessageHandler;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
@WebServlet(value={"/message"}, asyncSupported=true)
public class MessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");

        @SuppressWarnings("unchecked")
        List<MessageHandler> messageHandlerList = (List<MessageHandler>)req.getServletContext().getAttribute
                ("org.laborercode.kakaobot.MessageHandlerList");

        ObjectMapper mapper = new ObjectMapper();
        MessageRequest post = mapper.readValue(req.getInputStream(), MessageRequest.class);

        if("text".equals(post.getType())) {
            String content = post.getContent();
            if("도움말".equals(content)) {
                Message message = new Message();
                StringBuilder sb = new StringBuilder();
                for(MessageHandler handler : messageHandlerList) {
                    sb.append(handler.getMessage()).append(" : ").append(handler.getHelp())
                            .append("\n");
                }
                message.setText(sb.toString());
                MessageResponse mr = new MessageResponse();
                mr.setMessage(message);
                mapper.writeValue(resp.getOutputStream(), mr);
            } else {
                for(MessageHandler handler : messageHandlerList) {
                    if(handler.getMessage().equals(content)) {
                        AsyncContext asyncContext = req.startAsync();
                        asyncContext.start(new HandlerRunner(asyncContext, mapper,
                                handler, post));
                        break;
                    }
                }
            }
        }
    }

    public static class HandlerRunner implements Runnable {
        private AsyncContext asyncContext;
        private ObjectMapper mapper;
        private MessageHandler handler;
        private MessageRequest messageRequest;

        public HandlerRunner(AsyncContext asyncContext, ObjectMapper mapper,
                MessageHandler handler,
                MessageRequest post) {
            this.asyncContext = asyncContext;
            this.mapper = mapper;
            this.handler = handler;
            this.messageRequest = post;
        }

        public void run() {
            MessageResponse mr = handler.handle(messageRequest);
            try {
                mapper.writeValue(asyncContext.getResponse().getOutputStream(), mr);
            } catch (JsonGenerationException e) {
            } catch (JsonMappingException e) {
            } catch (IOException e) {
            } finally {
                asyncContext.complete();
            }
        }
    }
}
