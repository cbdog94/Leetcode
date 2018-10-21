import java.util.Arrays;

public class Q881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        if (people[0] > limit / 2) {
            return people.length;
        }
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                result++;
            } else {
                right--;
                result++;
            }
        }
        return result;
    }
}
