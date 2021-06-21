public class Q5637 {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            switch (s.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
                default:
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count--;
                    break;
                default:
            }
        }
        return count == 0;
    }
}
