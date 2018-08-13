import java.util.ArrayList;
import java.util.List;

public class Q535 {
    public static void main(String[] args) {
        Codec codec = new Q535().new Codec();
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }

    public class Codec {

        List<String> list = new ArrayList<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            list.add(longUrl);
            return "http://tinyurl.com/" + (list.size() - 1);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return list.get(Integer.valueOf(shortUrl.substring(shortUrl.lastIndexOf('/') + 1)));
        }
    }
}
