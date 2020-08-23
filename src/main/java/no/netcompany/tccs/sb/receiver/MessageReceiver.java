package no.netcompany.tccs.sb.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageReceiver {
    private final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    @JmsListener(destination = "test-queue")
    public void listener(String message){
        LOG.info("Message received {} ", message);
    }
}
