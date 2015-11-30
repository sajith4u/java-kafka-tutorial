package dev.innova.kafka.tutorial.producer;


import dev.innova.kafka.tutorial.beans.Notification;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class KafkaProducer {
    static String topic = "kafka-tutorial";


    public static void main(String[] args) {
        System.out.println("Start Kafka producer");
        Properties properties = new Properties();
        properties.put("metadata.broker.list", "localhost:9092");
        properties.put("serializer.class", "dev.innova.kafka.tutorial.producer.CustomSerializer");
        ProducerConfig producerConfig = new ProducerConfig(properties);
        kafka.javaapi.producer.Producer<String, Notification> producer = new kafka.javaapi.producer.Producer<String, Notification>(producerConfig);
        KeyedMessage<String, Notification> message = new KeyedMessage<String, Notification>(topic, createNotification());
        System.out.println("send Message to broker");
        producer.send(message);
        producer.close();

    }

    private static Notification createNotification(){
        Notification notification = new Notification();
        notification.setMessage("Sample Message");
        notification.setName("Sajith");
        notification.setCurrentTimeStamp(System.currentTimeMillis());
        return notification;
    }
}
