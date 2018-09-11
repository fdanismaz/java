package com.fd.tryout.jms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MyMessageListener {

    @JmsListener(destination = "${input.queue}")
    public void onMessageReceived(final Message message) throws JMSException {
        if (message instanceof TextMessage) {
            String text = ((TextMessage) message).getText();
            System.out.println(text);
        }
    }
}
