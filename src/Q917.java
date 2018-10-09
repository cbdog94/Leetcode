public class Q917 {

    public static void main(String[] args) {
        System.out.println(new Q917().reverseOnlyLetters("ab-cd"));
        System.out.println(new Q917().reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(new Q917().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String S) {
        char[] sc = S.toCharArray();
        int left = 0, right = sc.length - 1;
        while (left < right) {
            if (!Character.isLetter(sc[left])) {
                left++;
            } else if (!Character.isLetter(sc[right])) {
                right--;
            } else {
                char t = sc[left];
                sc[left] = sc[right];
                sc[right] = t;
                left++;
                right--;
            }
        }
        return new String(sc);
    }
}

/*
Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */
