import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class HW2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        semaphore.release();
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int[] labels = new int[M], hasChild = new int[M], POUDS = new int[M];
        for (int i = 0; i < M; i++) {
            labels[i] = scanner.nextInt();
        }
        for (int i = 0; i < M; i++) {
            hasChild[i] = scanner.nextInt();
        }
        for (int i = 0; i < M; i++) {
            POUDS[i] = scanner.nextInt();
        }
        int N = scanner.nextInt();
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextInt();
        }
        int P = scanner.nextInt();
        int[] keys = new int[P];
        for (int i = 0; i < P; i++) {
            keys[i] = scanner.nextInt();
        }

        System.out.println(new HW2().process(labels, hasChild, POUDS, values, keys));
    }

    private int process(int[] labels, int[] hasChild, int[] POUDS, int[] values, int[] keys) {
        List<Node> top = new ArrayList<>();
        List<Node> bottom = new ArrayList<>();
        int bottomNum, botI = 0;
        int topNum = 0;
        for (int i = 0; i < labels.length; i++) {
            if (hasChild[i] == 0) {
                bottom.add(new Node(values[botI++], labels[i], POUDS[i]));
                if (POUDS[i] == 1) {
                    topNum++;
                }
            }
            if (bottom.size() == values.length) {
                break;
            }
        }
        System.out.println(topNum);
        bottomNum = topNum;
        topNum = 0;
        for (int i = 0; i < labels.length; i++) {
            if (hasChild[i] == 1) {
                top.add(new Node(-1, labels[i], POUDS[i]));
                if (POUDS[i] == 1) {
                    topNum++;
                }
                if (top.size() == bottomNum) {
                    int t = -1;
                    for (int j = 0; j < bottom.size(); j++) {
                        if (bottom.get(j).POUDS == 1) {
                            top.get(++t).nodes[bottom.get(j).p] = bottom.get(j);
                        } else {
                            top.get(t).nodes[bottom.get(j).p] = bottom.get(j);
                        }
                    }
                    bottomNum = topNum;
                    bottom = top;
                    topNum = 0;
                    top = new ArrayList<>();

                }
            }
        }
        System.out.println();
        Node root = new Node(-1, -1, 0);
        for (int j = 0; j < bottom.size(); j++) {
            root.nodes[bottom.get(j).p] = bottom.get(j);
        }

        for (int k : keys) {
            if (root.nodes[k] != null) {
                root = root.nodes[k];
            } else {
                return 0;
            }
        }
        return root.v;
    }

    private class Node {
        int v, p, POUDS;
        Node[] nodes;

        Node(int v, int p, int POUDS) {
            this.v = v;
            this.p = p;
            this.POUDS = POUDS;
            nodes = new Node[256];
        }
    }
}
/*
15
115 112 116 97 111 121 114 101 105 112 121 114 102 115 116
0 0 0 1 1 0 1 0 0 0 0 1 1 1 1
1 1 0 1 0 1 1 1 0 0 0 1 1 0 0
8
1 2 3 4 5 6 7 8
3
116 114 112
* */