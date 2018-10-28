import java.util.HashSet;
import java.util.Set;

public class Q929 {

    public static void main(String[] args) {
        System.out.println(new Q929().numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            char[] sc = email.toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean flagPlus = false, flagDomain = false;
            for (char c : sc) {
                if (flagDomain) {
                    sb.append(c);
                } else {
                    if (flagPlus) {
                        if (c == '@') {
                            sb.append(c);
                            flagDomain = true;
                        }
                    } else {
                        if (c == '+') {
                            flagPlus = true;
                        } else if (c != '.') {
                            sb.append(c);
                        }
                    }
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
