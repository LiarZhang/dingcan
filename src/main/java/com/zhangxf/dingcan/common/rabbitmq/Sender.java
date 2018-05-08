package com.zhangxf.dingcan.common.rabbitmq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello My first RabbitMQ" + new SimpleDateFormat("yyyy-dd-mm HH:mm:ss").format(new Date());
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("RabbitMQHello", context);
    }

}
