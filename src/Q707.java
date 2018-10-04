public class Q707 {

    public static void main(String[] args) {
        Q707 q = new Q707();
        MyLinkedList list = q.new MyLinkedList();
        String call = "addAtHead,addAtHead,deleteAtIndex,addAtIndex,addAtTail,addAtIndex,addAtTail,addAtHead,addAtHead,addAtHead,addAtTail,addAtTail,addAtHead,addAtTail,addAtTail,addAtHead,addAtTail,deleteAtIndex,addAtTail,addAtTail,get,addAtIndex,addAtHead,get,get,addAtHead,get,addAtIndex,addAtTail,addAtIndex,addAtHead,addAtHead,addAtHead,get,addAtHead,addAtIndex,addAtTail,addAtHead,addAtIndex,get,addAtTail,addAtTail,addAtIndex,addAtIndex,addAtHead,addAtHead,get,addAtTail,addAtIndex,addAtIndex,addAtHead,deleteAtIndex,addAtIndex,addAtHead,deleteAtIndex,addAtTail,deleteAtIndex,addAtTail,addAtHead,addAtTail,addAtTail,addAtHead,addAtTail,addAtIndex,deleteAtIndex,addAtHead,addAtHead,addAtHead,addAtTail,get,addAtIndex,addAtTail,addAtTail,addAtTail,deleteAtIndex,get,addAtHead,get,get,addAtTail,deleteAtIndex,addAtTail,addAtIndex,addAtHead,addAtIndex,addAtTail,get,addAtIndex,addAtIndex,addAtHead,addAtHead,get,get,get,addAtIndex,addAtHead,addAtIndex,addAtHead,addAtTail,addAtIndex,get";
        String para = "[38],[45],[2],[1,24],[36],[3,72],[76],[7],[36],[34],[91],[69],[37],[38],[4],[66],[38],[14],[12],[32],[5],[7,5],[74],[7],[13],[11],[8],[10,9],[19],[3,76],[7],[37],[99],[10],[12],[1,20],[29],[42],[21,52],[11],[44],[47],[6,27],[31,85],[59],[57],[4],[99],[13,83],[10,34],[48],[9],[22,64],[69],[33],[5],[18],[87],[42],[1],[35],[31],[67],[36,46],[23],[64],[81],[29],[50],[23],[36,63],[8],[19],[98],[22],[28],[42],[24],[34],[32],[25],[53],[55,76],[38],[23,98],[27],[18],[44,27],[16,8],[70],[15],[9],[27],[59],[40,50],[15],[11,57],[80],[50],[23,37],[12]";
        String[] callSp = call.split(",");
        String[] paraSp = para.split(",");
        for (int i = 0; i < callSp.length; i++) {
            String ps = paraSp[i].substring(1, paraSp[i].length() - 1);
            System.out.println(callSp[i] + " " + ps);
            if ("addAtHead".equals(callSp[i])) {
                list.addAtHead(Integer.parseInt(ps));
            } else if ("addAtTail".equals(callSp[i])) {
                list.addAtTail(Integer.parseInt(ps));
            } else if ("addAtIndex".equals(callSp[i])) {
                String[] pss = ps.split(",");
                list.addAtIndex(Integer.parseInt(pss[0]), Integer.parseInt(pss[1]));
            } else if ("deleteAtIndex".equals(callSp[i])) {
                list.deleteAtIndex(Integer.parseInt(ps));
            } else {
                System.out.println(list.get(Integer.parseInt(ps)));
            }
        }
//        list.addAtHead(1);
//        list.addAtTail(3);
//        list.addAtIndex(1, 2);
//        System.out.println(list.get(1));
//        list.deleteAtIndex(1);
//        System.out.println(list.get(1));
    }

    class Node {
        int val;
        Node next, prev;

        Node(int val) {
            this.val = val;
        }
    }

    class MyLinkedList {

        int size = 0;
        Node head, tail;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = tail = new Node(0);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (size == 0) {
                addAtTail(val);
                return;
            }
            Node node = new Node(val);
            node.next = head.next;
            head.next = node;
            if (node.next != null) {
                node.next.prev = node;
            }
            node.prev = head;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node node = new Node(val);
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            Node cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            Node node = new Node(val);
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            Node cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            if (cur == tail) {
                tail = cur.prev;
                tail.next = null;
                cur.prev = null;
                cur.next = null;
            } else {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur.prev = null;
                cur.next = null;
            }
            size--;
        }
    }
}
