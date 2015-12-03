package dev.innova.kafka.tutorial.beans;


import java.io.Serializable;


public class Notification implements Serializable {
    private static final long serialVersionUID = 4733491116875354446L;
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
    public String toString() {
        return "Notification{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", currentTimeStamp=" + currentTimeStamp +
                '}';
    }
}
