# banco-message-broker

Exemplo de mensageria

- Um produtor [(Producer Repository)](https://github.com/43D/banco-message-broker/tree/producer) envia dados de transações bancarias via RabbitMQ para um consumidor [(Consumer Repository)](https://github.com/43D/banco-message-broker/tree/consumer).
- O consumidor deve simular 1 segundo de processamento.
- Caso tenha transações iguais ou maiores que 40.000 reais, enviar um alerta para Polícia Federal [(Policia Federal Repository)](https://github.com/43D/banco-message-broker/tree/policia.federal) e Receita Federal [(Receita Federal Repository)](https://github.com/43D/banco-message-broker/tree/receita.federal)