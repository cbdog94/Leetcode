import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
输入范例:
2019-04-30
2
2019-05-01T10:00:00~2019-05-01T13:00:00,2019-05-01T14:00:00~2019-05-01T18:00:00, 2019-05-02T11:00:00~2019-05-02T14:00:00
2019-05-01T9:00:00~2019-05-01T11:00:00,2019-05-01T12:00:00~2019-05-01T14:00:00
输出范例:
2019-05-02T9:00:00~2019-05-02T11:00:00

 */
public class Ali4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate today = LocalDate.parse(scanner.next());
        int n = scanner.nextInt();
        LocalDateTime start = today.plusDays(1).atTime(9, 0);
        //System.out.println(start);
        LocalDateTime min = null;
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            //System.out.println("--------");
            String s = scanner.nextLine();
            String[] periods = s.split(",");
            LocalDateTime lastStart = start;
            // System.out.println(lastStart);
            for (String period : periods) {
                // System.out.println(period);
                String[] sps = period.split("~");
                LocalDateTime pStart = LocalDateTime.parse(sps[0].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'H:mm:ss")), pEnd = LocalDateTime.parse(sps[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'H:mm:ss"));
                Duration duration = Duration.between(lastStart, pStart);
                //System.out.println(duration.toHours());
                if (duration.toHours() >= 2) {
                    if (min == null || lastStart.compareTo(min) < 0) {
                        min = lastStart;
                    }
                }
                lastStart = Duration.between(pEnd, pEnd.toLocalDate().atTime(19, 0)).toHours() < 2 ? pEnd.toLocalDate().plusDays(1).atTime(9, 0) : pEnd;
            }
            if (Duration.between(lastStart, lastStart.toLocalDate().atTime(19, 0)).toHours() >= 2) {
                if (min == null || lastStart.compareTo(min) < 0) {
                    min = lastStart;
                }
            }
        }
        if (min == null || min.compareTo(today.plusDays(7).atTime(9, 0)) >= 0) {
            System.out.println();
        } else {
            System.out.println(min + "~" + min.plusHours(2));
        }

    }
}