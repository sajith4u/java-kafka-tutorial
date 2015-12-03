package dev.innova.test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serialize.FieldSerializer;
import com.esotericsoftware.kryo.serialize.StringSerializer;
import dev.innova.kafka.tutorial.beans.Notification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

public class SerializerTest {

    Kryo kryo;
    ByteBuffer buffer = ByteBuffer.allocateDirect(1028);
    protected Logger logger = LoggerFactory.getLogger(SerializerTest.class);

    @Before
    public void setUp() {
        kryo = new Kryo();
        kryo.register(Notification.class, new FieldSerializer(kryo, Notification.class));
    }

    @Test
    public void stringSerialize() throws Exception {
        logger.info("serialization test case");
        StringSerializer stringSerializer = new StringSerializer();
        stringSerializer.writeObjectData(buffer, "Sample Test");
        buffer.flip();
        String text = stringSerializer.readObjectData(buffer, String.class);
        Assert.assertTrue(text.equals("Sample Test"));
    }

    @Test
    public void testNotificationSerializer() throws Exception {
        Notification notification = new Notification();
        notification.setMessage("Sample Message");
        notification.setCurrentTimeStamp(System.currentTimeMillis());
        notification.setName("Sajith");

        kryo.writeObject(buffer, notification);
        buffer.flip();

        Notification s = kryo.readObject(buffer, Notification.class);
        if (s != null) {
            System.out.println("Notification :" + s.toString());
        } else {
            System.out.println("Serialization failed");
        }
    }
}
