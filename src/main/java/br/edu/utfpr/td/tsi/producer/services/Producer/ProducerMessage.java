package br.edu.utfpr.td.tsi.producer.services.Producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.dto.Transaction;

@Component
public class ProducerMessage implements iProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;
    
    @Override
    public void sendTransaction(Transaction transaction) {
        rabbitTemplate.convertAndSend(this.queue.getName(), transaction.toString());
    }
}
