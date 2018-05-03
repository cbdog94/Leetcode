import java.util.Scanner;

public class MT {

    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        for(int i=0;i<n;i++){
//            System.out.println(f(scanner.nextLong()));
//        }
        int p=10003;
        int x1=p;
        for(int i=1;i<15;i++){
            System.out.println(x1);
            x1=(x1+153)%p;
        }
    }

    private static long f(long l) {
//        if(l<10)
//            return l;
        long total=0;
        int length=(int)(Math.ceil(Math.log10(l+1)));
//        System.out.println(length);
        for(int i=1;i<length;i++){
            total+=(Math.pow(10,i)-Math.pow(10,i-1))*i;
        }
        l-=Math.pow(10,length-1);
//        System.out.println(l);
        total+=(l+1)*length;
        return total;
    }


}
