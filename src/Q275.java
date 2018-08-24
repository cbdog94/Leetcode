public class Q275 {

    public int hIndex(int[] citations) {
        int length = citations.length;
        int left = 0, right = length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (citations[mid] >= length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return length - left;
    }

}
