public class Q273 {

    public static void main(String[] args) {
        String s = "120&105&112&105&103&115&113&101&104&113&109&114&48&48&57&49&56&57&57&56";
        String[] sp = s.split("&");
        for (String s1 : sp) {
            System.out.print((char) Integer.parseInt(s1));
        }
        System.out.println(new Q273().numberToWords(1) + "|");
        System.out.println(new Q273().numberToWords(10) + "|");
        System.out.println(new Q273().numberToWords(15) + "|");
        System.out.println(new Q273().numberToWords(20) + "|");
        System.out.println(new Q273().numberToWords(21) + "|");
        System.out.println(new Q273().numberToWords(123) + "|");
        System.out.println(new Q273().numberToWords(12345) + "|");
        System.out.println(new Q273().numberToWords(1234567891) + "|");
        System.out.println(new Q273().numberToWords(1234567) + "|");
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        if (num >= 1000000000) {
            result = result + threeDigits(num / 1000000000) + " Billion ";
            num -= num / 1000000000 * 1000000000;
        }
        if (num >= 1000000) {
            result = result + threeDigits(num / 1000000) + " Million ";
            num -= num / 1000000 * 1000000;
        }
        if (num >= 1000) {
            result = result + threeDigits(num / 1000) + " Thousand ";
            num -= num / 1000 * 1000;
        }
        result = result + threeDigits(num);
        return result.trim();
    }

    private String threeDigits(int num) {
        String[] map = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] map10 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String result = "";
        if (num >= 100) {
            result = result + map[num / 100] + " Hundred";
            num -= num / 100 * 100;
        }
        if (num < 20) {
            result = result + " " + map[num];
        } else {
            result = result + " " + map10[num / 10] + " " + map[num % 10];
        }
        return result.trim();
    }
}
