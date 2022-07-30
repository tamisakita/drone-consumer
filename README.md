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

## Configurações

* Criar uma conta no [MailJet](https://www.mailjet.com/) e gerar as chaves de API no [link](https://app.mailjet.com/account/apikeys):
![alt text](https://github.com/tamisakita/drone-consumer/blob/main/criando-chave-api.png "Chave API")

* Na pasta Resources criar o application.properties e adicionar o código para configurar o RabbitMQ
```java
spring.rabbitmq.addresses=amqps://*****

queue.name=fiap.scj.mensagens

mailjeft.apikey=*****

mailjeft.secretkey=*****

mailjeft.sender=*****

mailjeft.receiver=*****

mailjeft.sendername=*****

mailjeft.receivername=*****
```

## Funcionalidade

### RabbitMQ 
![alt text](https://github.com/tamisakita/drone-consumer/blob/main/rabbitMQ.pnghttps://github.com/tamisakita/drone-consumer/blob/main/rabbitMQ.png "RabbitMQ")

### Recebendo os dados no Consumer
![alt text](https://github.com/tamisakita/drone-consumer/blob/main/drone-consumer-teste-postman.png "Consumer")

### Recebendo os dados no Email
![alt text](https://github.com/tamisakita/drone-consumer/blob/main/email.png "Email")

## Author & Version Control
[Patricia Tami Sakita](https://github.com/tamisakita) and [Gustavo Ceccon](https://github.com/gfcecconhttps://github.com/gfceccon) - Drone Project v.01

