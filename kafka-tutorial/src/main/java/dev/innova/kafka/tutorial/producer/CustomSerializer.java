package dev.innova.kafka.tutorial.producer;

import dev.innova.kafka.tutorial.beans.Notification;
import kafka.serializer.Decoder;
import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;


public class CustomSerializer implements Encoder<Notification>, Decoder<Notification> {
    public CustomSerializer(VerifiableProperties verifiableProperties) {
        /* This constructor must be present for successful compile. */
    }
    @Override
    public byte[] toBytes(Notification o) {
        return new byte[0];
    }

    @Override
    public Notification fromBytes(byte[] bytes) {
        return null;
    }
}
