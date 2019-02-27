public class Q838 {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j = 0; j < dominoes.length(); j++) {
            char c = dominoes.charAt(j), init = dominoes.charAt(i);
            if (c == 'L') {
                if (dominoes.charAt(i) != 'R') {
                    for (int k = i; k <= j; k++) {
                        sb.append('L');
                    }
                } else {
                    for (int k = 0; k < (j - i + 1) / 2; k++) {
                        sb.append('R');
                    }
                    if ((j - i + 1) % 2 != 0) {
                        sb.append('.');
                    }
                    for (int k = 0; k < (j - i + 1) / 2; k++) {
                        sb.append('L');
                    }
                }
                i = j + 1;
            } else if (c == 'R') {
                if (i != j) {
                    if (dominoes.charAt(i) == 'R') {
                        for (int k = i; k < j; k++) {
                            sb.append('R');
                        }
                        i = j;
                    } else if (dominoes.charAt(i) == '.') {
                        for (int k = i; k < j; k++) {
                            sb.append('.');
                        }
                        i = j;
                    }
                }
            }
        }
        if (i != dominoes.length()) {
            for (int k = i; k < dominoes.length(); k++) {
                sb.append(dominoes.charAt(i));
            }
        }
        return sb.toString();
    }
}
