package br.edu.utfpr.td.tsi.receita.federal;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class BrokenConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("transacoes.suspeitas", true, false);
    }

    @Bean
    public Queue receitaFederalQueue() {
        return new Queue("receita.federal", true);
    }

    @Bean
    public Binding bindingReceitaFederal(Queue receitaFederalQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(receitaFederalQueue).to(fanoutExchange);
    }

    @PostConstruct
    private void init() {
        Queue qReceitaFederal = receitaFederalQueue();
        amqpAdmin.declareQueue(qReceitaFederal);
        FanoutExchange fanout = fanoutExchange();
        amqpAdmin.declareExchange(fanout);
        amqpAdmin.declareBinding(bindingReceitaFederal(qReceitaFederal, fanout));
    }
}
