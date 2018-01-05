package com.phfund.aplus;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
	 public class Sender{
	     @Autowired
	     private AmqpTemplate rabbitTemplate;
	     
	     

	     public void send() {
	         String sendMsg = "hello" + new Date();
	         System.out.println("Sender: " + sendMsg);
	         this.rabbitTemplate.convertAndSend("exchange", "hello.abc", sendMsg);
	     }
	     
	     @Bean
	     public Queue helloln() {
	         return new Queue("helloln");
	     }
	     
	     @Bean
	     public Queue helloQueue() {
	         return new Queue("helloQueue");
	     }
	     
	     @Bean
	     TopicExchange exchange() {
	         return new TopicExchange("exchange");
	     }
	     
	     @Bean
	     Binding bindingExchange(Queue helloln, TopicExchange exchange) {
	         return BindingBuilder.bind(helloln).to(exchange).with("#");
	     }
	     
	     @Bean
	     Binding bindingExchangeMe(Queue helloQueue, TopicExchange exchange) {
	         return BindingBuilder.bind(helloQueue).to(exchange).with("#");
	     }
	     

	 }
