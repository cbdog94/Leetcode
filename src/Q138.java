import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q138 {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode result = null, headCur = head, resultCur = null, tmp;
        int index = 0;
        Map<RandomListNode, Integer> mapOrigin = new HashMap<>();
        //Map<RandomListNode,Integer> mapCopy=new HashMap<>();
        List<RandomListNode> listCopy = new ArrayList<>();

        while (headCur != null) {
            tmp = new RandomListNode(headCur.label);
            if (result == null) {
                result = tmp;
            } else {
                resultCur.next = tmp;
            }
            resultCur = tmp;
            mapOrigin.put(headCur, index++);
            listCopy.add(tmp);
            headCur = headCur.next;
        }

        headCur = head;
        resultCur = result;
        while (headCur != null) {
            resultCur.random = listCopy.get(mapOrigin.get(headCur.random));
            headCur = headCur.next;
            resultCur = resultCur.next;
        }

        return result;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}
