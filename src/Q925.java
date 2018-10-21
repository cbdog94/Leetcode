public class Q925 {

    public boolean isLongPressedName(String name, String typed) {
        char[] nc = name.toCharArray(), tc = typed.toCharArray();
        int ni = 0, ti = 0, nl = nc.length, tl = tc.length;
        while (ni < nl && ti < tl) {
            if (nc[ni] == tc[ti]) {
                ni++;
                ti++;
            } else {
                if (ti > 0 && tc[ti] == tc[ti - 1]) {
                    ti++;
                } else {
                    return false;
                }
            }
        }
        return ni == nl;
    }

}
