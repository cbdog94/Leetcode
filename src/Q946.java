public class Q946 {
    public static void main(String[] args) {
        System.out.println(new Q946().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Q946().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] pos = new int[1000];
        for (int i = 0; i < pushed.length; i++) {
            pos[pushed[i]] = i;
        }
        int max = pos[popped[0]];
        for (int i = 1; i < popped.length; i++) {
            if (pos[popped[i]] > pos[popped[i - 1]]) {
                if (pos[popped[i]] < max) {
                    return false;
                }
                max = pos[popped[i]];
            }
        }
        return true;
    }
}
