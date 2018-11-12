public class Q937 {
    public String[] reorderLogFiles(String[] logs) {
        for (int i = 0; i < logs.length; i++) {
            for (int j = 0; j < logs.length - 1 - i; j++) {
                if (compareTo(logs[j], logs[j + 1])) {
                    String t = logs[j];
                    logs[j] = logs[j + 1];
                    logs[j + 1] = t;
                }
            }
        }
        return logs;
    }

    private boolean compareTo(String a, String b) {
        a = a.substring(a.indexOf(' ') + 1);
        b = b.substring(b.indexOf(' ') + 1);
        if (Character.isDigit(b.charAt(0))) {
            return false;
        }
        if (Character.isDigit(a.charAt(0))) {
            return true;
        }
        return a.compareTo(b) > 0;
    }
}
