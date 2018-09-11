package com.fd.tryout.jms.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JmsTestRouter extends RouteBuilder {

    static final Logger log = LoggerFactory.getLogger(JmsTestRouter.class);

    @Override
    public void configure() throws Exception {
        System.out.println("Configuring route");

        from("{{input.queue}}")
                .log(LoggingLevel.DEBUG, log, "New message received")
                .process(exchange -> {
                    String convertedMessage = exchange.getMessage().getBody() + " is converted";
                    exchange.getMessage().setBody(convertedMessage);
                })
                .to("{{output.queue}}")
                .log(LoggingLevel.DEBUG, log, "Message sent to the other queue")
        .end();

    }
}
