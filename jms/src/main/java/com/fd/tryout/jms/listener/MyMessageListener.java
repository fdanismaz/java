package com.fd.tryout.jms.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
@Component
public class MyMessageListener {

    @JmsListener(destination = "${input.queue}")
    public void onMessageReceived(final Message message) throws JMSException {
        if (message instanceof TextMessage) {
            String text = ((TextMessage) message).getText();
            log.debug("Message received" + text);
        }
    }
}
