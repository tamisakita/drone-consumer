# Drone Project - Consumer

Este é o trabalho final para a matéria Integrations & Development Tools do curso FIAP-FullStack em colaboração entre Patricia T S Chung e Gustavo Ceccon.

## Introdução

Desenvolvemos uma solução para o agronegócio que a coleta de dados via sensores de temperatura e umidade. Esses sensores ficarão instalados em um drone com uma altíssima economia pois conta com pequenos, porém muito eficientes painéis fotovoltaicos. 
A cada 10 segundos são enviados para message broker os dados de temperatura e umidade capturado naquele instante.

Este é o componente Consumer, você pode conferir o componente Producer neste link => [Link](https://github.com/tamisakita/drone-producer)

## Tecnologias
* Java 18;
* SpringBoot;
* RabbitMQ;
* IntelliJ

## Getting Started

* Criar uma conta no [CloudAMQP](https://customer.cloudamqp.com/instancehttps://customer.cloudamqp.com/instance) para acessar o [RabbitMQ](https://jackal.rmq.cloudamqp.com/#/https://jackal.rmq.cloudamqp.com/#/)

* Na pasta Resources criar o application.properties e adicionar o código para configurar o RabbitMQ
```java
spring.rabbitmq.addresses=amqps://qlaczvbi:57UWEGtaVc4iWep3VyP3k65bQxvXk2fF@jackal.rmq.cloudamqp.com/qlaczvbi

queue.name=fiap.scj.mensagens
```

## Funcionalidades

## Author & Version Control
[Patricia Tami Sakita](https://github.com/tamisakita) and [Gustavo Ceccon](https://github.com/gfcecconhttps://github.com/gfceccon) - Drone Project v.01

