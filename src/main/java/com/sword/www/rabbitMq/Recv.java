package com.sword.www.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

/**
* @author  linmeng
 * @desc 接收类
* @exception Exception
* @date        2020/6/3 22:44
*/
public class Recv {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        DeliverCallback deliverCallback = (consumerTag,delivery)->{
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("[x] Reveived "+message);
        };
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,consumeTag->{});
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    }
}
