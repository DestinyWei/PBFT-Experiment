package PBFT;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 节点类
 * @author: weihaoming
 * @version: 0.1.0
 */

public class Node {
    private int id;
    private boolean isFaulty;
    private List<Message> messageLog;

    public Node(int id, boolean isFaulty) {
        this.id = id;
        this.isFaulty = isFaulty;
        this.messageLog = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFaulty(boolean faulty) {
        isFaulty = faulty;
    }

    public List<Message> getMessageLog() {
        return messageLog;
    }

    public void setMessageLog(List<Message> messageLog) {
        this.messageLog = messageLog;
    }

    public boolean isFaulty() {
        return isFaulty;
    }

    public void receiveMessage(Message message) {
        messageLog.add(message);
        System.out.println("Node " + id + " received message: " + message);
    }

    public Message sendMessage() {
        if (messageLog.size() > 0) {
            Message message = messageLog.get(messageLog.size() - 1);
            System.out.println("Node " + id + " sent message: " + message);
            return message;
        } else {
            return null;
        }
    }

    public void executeRequest(String request) {
        System.out.println("Node " + id + " executed request: " + request);
    }
}