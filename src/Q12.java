public class Q12 {

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 1000) {
            sb.append('M');
            num -= 1000;
        }
        if (num / 100 == 9) {
            sb.append("CM");
            num -= 900;
        }
        if (num > 500) {
            sb.append('D');
            num -= 500;
        }
        if (num / 100 == 4) {
            sb.append("CD");
            num -= 400;
        }
        while (num > 100) {
            sb.append('C');
            num -= 100;
        }
        if (num / 10 == 9) {
            sb.append("XC");
            num -= 90;
        }
        if (num > 50) {
            sb.append('L');
            num -= 50;
        }
        if (num / 10 == 4) {
            sb.append("XL");
            num -= 40;
        }
        while (num > 10) {
            sb.append('X');
            num -= 10;
        }
        if (num == 9) {
            sb.append("IX");
            num -= 9;
        }
        if (num > 5) {
            sb.append('V');
            num -= 5;
        }
        if (num == 4) {
            sb.append("IV");
            num -= 4;
        }
        while (num > 0) {
            sb.append('I');
            num -= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

}
