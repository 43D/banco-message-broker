package br.edu.utfpr.td.tsi.consumer.services.consumer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.builder.iTransactionBuilder;
import br.edu.utfpr.td.tsi.consumer.services.specification.SuspiciousTransactionSpecification;
import br.edu.utfpr.td.tsi.consumer.util.Timer;
import br.edu.utfpr.td.tsi.dto.Transaction;

@Component
public class MessageReceiver {
    @Autowired
    private iTransactionBuilder transactionBuilder;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    @RabbitListener(queues = "transacoes.financeiras")
    public void receiveMessage(String message) {
        Transaction dto = transactionBuilder.createTransactionFromJson(message).builder();
        Timer.awaitOneSecond();
        System.out.println("Mensagem recebida: " + dto.toString());
        if (SuspiciousTransactionSpecification.checkTransaction(dto)){
            System.out.println("Alerta: " + dto.toString());
            this.sendMessageToFanoutExchange(dto.toString());
        }
    }

    public void sendMessageToFanoutExchange(String message) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
    }
}
