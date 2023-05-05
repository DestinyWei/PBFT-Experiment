package PBFT;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 共识成功主类
 * @author: weihaoming
 * @version: 0.1.0
 */

public class ConsensusSuccess {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(0, false));
        nodes.add(new Node(1, false));
        nodes.add(new Node(2, false));
        nodes.add(new Node(3, false));

        PBFT.PBFTConsensus pbftConsensus = new PBFT.PBFTConsensus();
        pbftConsensus.reachConsensus(nodes, "Hello, Blockchain!");
    }
}

