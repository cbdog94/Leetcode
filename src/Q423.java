public class Q423 {

    // one      seven  nine
    public static String originalDigits(String s) {
        int[] count = new int[10];
        int[] fre = new int[26];
        char[] sc = s.toCharArray();
        for (char aSc : sc) {
            fre[aSc - 'a']++;
        }
        //0
        count[0] = fre['z' - 'a'];
        fre['e' - 'a'] -= count[0];
        fre['r' - 'a'] -= count[0];
        fre['o' - 'a'] -= count[0];
        //2
        count[2] = fre['w' - 'a'];
        fre['t' - 'a'] -= count[2];
        fre['o' - 'a'] -= count[2];
        //6
        count[6] = fre['x' - 'a'];
        fre['s' - 'a'] -= count[6];
        fre['i' - 'a'] -= count[6];
        //8
        count[8] = fre['g' - 'a'];
        fre['e' - 'a'] -= count[8];
        fre['i' - 'a'] -= count[8];
        fre['h' - 'a'] -= count[8];
        fre['t' - 'a'] -= count[8];
        //3
        count[3] = fre['h' - 'a'];
        fre['t' - 'a'] -= count[3];
        fre['r' - 'a'] -= count[3];
        fre['e' - 'a'] -= count[3] * 2;
        //4
        count[4] = fre['r' - 'a'];
        fre['f' - 'a'] -= count[4];
        fre['o' - 'a'] -= count[4];
        fre['u' - 'a'] -= count[4];
        //5
        count[5] = fre['f' - 'a'];
        fre['i' - 'a'] -= count[5];
        fre['v' - 'a'] -= count[5];
        fre['e' - 'a'] -= count[5];
        count[1] = fre['o' - 'a'];
        count[7] = fre['v' - 'a'];
        count[9] = fre['i' - 'a'];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
    }

}
