package no.netcompany.tccs.sb.sender;

import no.netcompany.tccs.sb.config.JmsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/send")
public class SenderRest {
    private final Logger LOG = LoggerFactory.getLogger(SenderRest.class);


    private final Queue queue;
    private final JmsTemplate jmsTemplate;

    @Autowired
    public SenderRest(final Queue queue, final JmsTemplate jmsTemplate) {
        this.queue = queue;
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping("{message}")
    public ResponseEntity<String> sendMessage(@PathVariable("message") final String message){
        LOG.info("Addedd {} to queue {}", message, queue);
        jmsTemplate.convertAndSend(queue, message);
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
