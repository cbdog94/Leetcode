public class Q165 {

    public static int compareVersion(String version1, String version2) {
        String[] splits1 = version1.split("\\.");
        String[] splits2 = version2.split("\\.");
        for (int i = 0; i < Math.min(splits1.length, splits2.length); i++) {
            if (!splits1[i].equals(splits2[i])) {
                return Integer.compare(Integer.parseInt(splits1[i]), Integer.parseInt(splits2[i]));
            }
        }
        if (splits1.length < splits2.length) {
            for (int i = splits1.length; i < splits2.length; i++) {
                if (Integer.parseInt(splits2[i]) != 0) {
                    return -1;
                }
            }
        } else {
            for (int i = splits2.length; i < splits1.length; i++) {
                if (Integer.parseInt(splits1[i]) != 0) {
                    return 1;
                }
            }
        }
        return 0;
//        return Integer.compare(splits1.length, splits2.length);
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("7.5.2.4", "7.5.2.4"));
        System.out.println(compareVersion("01", "1"));
        System.out.println(compareVersion("1.0", "1"));
    }
}
