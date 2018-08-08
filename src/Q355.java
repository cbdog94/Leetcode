import java.util.*;

public class Q355 {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
//        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
// User 1's news feed should return a list with 1 tweet id -> [5].
//        twitter.getNewsFeed(1);
        System.out.println(twitter.getNewsFeed(1));
// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1);
        System.out.println(twitter.getNewsFeed(1));
// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));
    }

    static class Twitter {

        Map<Integer, Set<Integer>> userFollow;
        Map<Integer, List<Integer>> userPost;
        Map<Integer, Integer> timeMap;
        int time = 0;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userFollow = new HashMap<>();
            userPost = new HashMap<>();
            timeMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (!userPost.containsKey(userId)) {
                userPost.put(userId, new ArrayList<>());
                if (!userFollow.containsKey(userId)) {
                    userFollow.put(userId, new HashSet<>());
                }
                userFollow.get(userId).add(userId);
            }
            userPost.get(userId).add(tweetId);
            timeMap.put(tweetId, time++);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            if (!userFollow.containsKey(userId)) {
                return new ArrayList<>();
            }
            Set<Integer> userList = userFollow.get(userId);
            Map<Integer, Integer> postMap = new HashMap<>();
            for (Integer userID : userList) {
                for (Integer tweetId : userPost.getOrDefault(userID, new ArrayList<>())) {
                    postMap.put(tweetId, timeMap.get(tweetId));
                }
            }
            List<Map.Entry<Integer, Integer>> allResult = new ArrayList<>(postMap.entrySet());
            allResult.sort((o1, o2) -> o2.getValue() - o1.getValue());
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < 10 && i < allResult.size(); i++) {
                result.add(allResult.get(i).getKey());
            }
            return result;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (!userFollow.containsKey(followerId)) {
                userFollow.put(followerId, new HashSet<>());
            }
            userFollow.get(followerId).add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            if (userFollow.containsKey(followerId)) {
                userFollow.get(followerId).remove(followeeId);
            }
        }
    }


}
