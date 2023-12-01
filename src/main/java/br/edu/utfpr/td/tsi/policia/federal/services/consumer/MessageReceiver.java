package br.edu.utfpr.td.tsi.policia.federal.services.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MessageReceiver {

    @RabbitListener(queues = "policia.federal")
    public void receiveMessage(String message) {
        System.out.println("Processando transação suspeita: " + message);
    }
}
