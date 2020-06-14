package com.sword.www.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

/**
* @author  linmeng
* @exception Exception
* @date        2020/6/3 22:44
*/
public class Send {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()){
            channel.basicQos(1);
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "hello world";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] Sent message "+message);
        }
    }
}
