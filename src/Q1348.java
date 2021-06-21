import java.util.*;

public class Q1348 {
    class TweetCounts {

        Map<String, TreeMap<Integer, Integer>> map;

        public TweetCounts() {
            map = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            if (!map.containsKey(tweetName)) {
                map.put(tweetName, new TreeMap<>());
            }
            int times = map.get(tweetName).getOrDefault(time, 0);
            map.get(tweetName).put(time, times + 1);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            int interval = 0;
            switch (freq) {
                case "minute":
                    interval = 60;
                    break;
                case "hour":
                    interval = 3600;
                    break;
                case "day":
                    interval = 3600 * 24;
                    break;
                default:
            }
            TreeMap<Integer, Integer> curTweet = map.get(tweetName);
            List<Integer> res = new ArrayList<>();
            for (int i = startTime; i <= endTime; i += interval) {
                int num = 0;
                for (int v : curTweet.subMap(i, i + interval).values()) {
                    num += v;
                }
                res.add(num);
            }
            return res;
        }
    }
}
