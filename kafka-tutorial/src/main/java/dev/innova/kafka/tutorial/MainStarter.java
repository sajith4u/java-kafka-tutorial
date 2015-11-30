package dev.innova.kafka.tutorial;


import dev.innova.kafka.tutorial.consumer.KafkaConcumer;

public class MainStarter {
    public static void main(String[] args) {
        System.out.println("Kafka-tutorial");
        KafkaConcumer kafkaConcumer = new KafkaConcumer();
        kafkaConcumer.start();

    }
}
