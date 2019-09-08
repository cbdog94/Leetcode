import java.util.Scanner;

public class Ctrip1 {

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode tl = left, tr = right;
        while (head != null) {
            if (head.val <= m) {
                tl.next = new ListNode(head.val);
                tl = tl.next;
            } else {
                tr.next = new ListNode(head.val);
                tr = tr.next;
            }
            head = head.next;
        }
        if (left.next == null) {
            return right.next;
        }
        tl.next = right.next;
        return left.next;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
