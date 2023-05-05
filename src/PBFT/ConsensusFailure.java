package PBFT;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 共识失败主类
 * @author: weihaoming
 * @version: 0.1.0
 */

public class ConsensusFailure {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(0, false));
        nodes.add(new Node(1, true)); // 故障节点
        nodes.add(new Node(2, false));
        nodes.add(new Node(3, false));

        PBFTConsensus pbftConsensus = new PBFTConsensus();
        pbftConsensus.reachConsensus(nodes, "Hello, Blockchain!");
    }
}

