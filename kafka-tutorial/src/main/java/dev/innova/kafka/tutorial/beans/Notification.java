package dev.innova.kafka.tutorial.beans;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.Serializable;
import java.sql.Time;
import java.util.Timer;

/**
 * Created by sajithv on 11/30/15.
 */
public class Notification implements Serializable{
    private static final long serialVersionUID = 123L;
    private String name;
    private String message;
    private long currentTimeStamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(long currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (currentTimeStamp != that.currentTimeStamp) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (int) (currentTimeStamp ^ (currentTimeStamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", currentTimeStamp=" + currentTimeStamp +
                '}';
    }
}
