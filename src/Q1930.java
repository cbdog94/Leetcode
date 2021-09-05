import java.util.Arrays;

public class Q1930 {
    public int countPalindromicSubsequence(String s) {
        int[] left=new int[26], right =new int[26];
        Arrays.fill(left, Integer.MAX_VALUE);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            left[c-'a']=Math.min(left[c-'a'], i);
            right[c-'a']=i;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(left[i]+1<right[i]){
                count+=s.substring(left[i]+1, right[i]).chars().distinct().count();
            }
        }
        return count;
    }
}
