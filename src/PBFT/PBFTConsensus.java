package PBFT;

import java.util.List;
import java.util.Random;

/**
 * @description: 节点类
 * @author: weihaoming
 * @version: 0.1.0
 */

public class PBFTConsensus {
//    private static final int f = 1;
//    private static final int n = 4;

    public void reachConsensus(List<Node> nodes, String request) {
        int n = nodes.size();
        int f = (n - 1) / 3;
        // 模拟网络延迟
        Random random = new Random();

        // Pre-prepare阶段
        System.out.println("----- Pre-prepare阶段 -----");
        for (Node node : nodes) {
            if (!node.isFaulty()) {
                Message message = new Message(request);
                node.receiveMessage(message);
                System.out.println("Node " + node.getId() + " sent pre-prepare message: " + message);
                System.out.println("-----------------");
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Prepare阶段
        System.out.println("----- Prepare阶段 -----");
        int prepareCount = 0;
        for (Node node : nodes) {
            if (!node.isFaulty()) {
                Message message = node.sendMessage();
                if (message != null) {
                    prepareCount++;
                    System.out.println("Node " + node.getId() + " sent prepare message: " + message);
                    System.out.println("-----------------");
                }
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Commit阶段
        System.out.println("----- Commit阶段 -----");
        if (prepareCount > 3 * f) {
            int commitCount = 0;
            for (Node node : nodes) {
                if (!node.isFaulty()) {
                    Message message = node.sendMessage();
                    if (message != null) {
                        commitCount++;
                        System.out.println("Node " + node.getId() + " sent commit message: " + message);
                        System.out.println("-----------------");
                    }
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            // Reply阶段
            System.out.println("----- Reply阶段 -----");
            if (commitCount > 3 * f) {
                for (Node node : nodes) {
                    if (!node.isFaulty()) {
                        node.executeRequest(request);
                        System.out.println("Node " + node.getId() + " sent reply message.");
                        System.out.println("-----------------");
                        try {
                            Thread.sleep(random.nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("Consensus Success!");
            } else {
                System.out.println("Consensus failed: Not enough commit messages.");
            }
        } else {
            System.out.println("Consensus failed: Not enough prepare messages.");
        }
    }
}