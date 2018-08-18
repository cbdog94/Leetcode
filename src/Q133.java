import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q133 {

    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        //重要，终止递归
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode tmp = new UndirectedGraphNode(node.label);
        map.put(node.label, tmp);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            tmp.neighbors.add(clone(neighbor));
        }
        return tmp;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }


}
