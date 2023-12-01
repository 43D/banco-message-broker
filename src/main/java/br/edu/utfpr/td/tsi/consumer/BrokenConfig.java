package br.edu.utfpr.td.tsi.consumer;

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
    @Bean
	public Queue myQueue() {
		return new Queue("transacoes.financeiras", true);
	}

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    private void init() {
        amqpAdmin.declareQueue(myQueue());
        Queue qPoliciaFederal = policiaFederalQueue();
        amqpAdmin.declareQueue(qPoliciaFederal);
        Queue qReceitaFederal = receitaFederalQueue();
        amqpAdmin.declareQueue(qReceitaFederal);
        FanoutExchange fanout = fanoutExchange();
        amqpAdmin.declareExchange(fanout);
        amqpAdmin.declareBinding(bindingPoliciaFederal(qPoliciaFederal, fanout));
        amqpAdmin.declareBinding(bindingReceitaFederal(qReceitaFederal, fanout));
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("transacoes.suspeitas", true, false);
    }

    @Bean
    public Queue policiaFederalQueue() {
        return new Queue("policia.federal", true);
    }

    @Bean
    public Queue receitaFederalQueue() {
        return new Queue("receita.federal", true);
    }

    @Bean
    public Binding bindingPoliciaFederal(Queue policiaFederalQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(policiaFederalQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingReceitaFederal(Queue receitaFederalQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(receitaFederalQueue).to(fanoutExchange);
    }
}
