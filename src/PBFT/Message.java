package PBFT;

/**
 * @description: 消息类
 * @author: weihaoming
 * @version: 0.1.0
 */
public class Message {
    private long timestamp;
    private String request;

    public Message(String request) {
        this.request = request;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getRequest() {
        return request;
    }

    @Override
    public String toString() {
        return "Message{" +
                "timestamp=" + timestamp +
                ", request='" + request + '\'' +
                '}';
    }
}