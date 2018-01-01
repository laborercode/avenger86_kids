package org.laborercode.kakaobot;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.laborercode.kakaobot.message.AccountMessageHandler;
import org.laborercode.kakaobot.message.BalanceMessageHandler;
import org.laborercode.kakaobot.message.MessageHandler;
import org.laborercode.kakaobot.message.ScheduleMessageHandler;

@WebListener
public class MessageHandlerInitializer implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        List<MessageHandler> messageHandlerList = new ArrayList<MessageHandler>();

        messageHandlerList.add(new BalanceMessageHandler());
        messageHandlerList.add(new AccountMessageHandler());
        messageHandlerList.add(new ScheduleMessageHandler());

        sce.getServletContext().setAttribute("org.laborercode.kakaobot.MessageHandlerList", messageHandlerList);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

}
