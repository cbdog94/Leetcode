import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Tran>> map = new HashMap<>();
        for (String t : transactions) {
            String[] sps = t.split(",");
            if (!map.containsKey(sps[0])) {
                map.put(sps[0], new ArrayList<>());
            }
            map.get(sps[0]).add(new Tran(sps[0], Integer.parseInt(sps[1]), Integer.parseInt(sps[2]), sps[3]));
        }
        List<String> res = new ArrayList<>();
        for (List<Tran> ts : map.values()) {
            for (int i = 0; i < ts.size(); i++) {
                if (ts.get(i).amount > 1000) {
                    res.add(ts.get(i).toString());
                    continue;
                }
                for (int j = 0; j < ts.size(); j++) {
                    if (!ts.get(j).city.equals(ts.get(i).city) && Math.abs(ts.get(j).time - ts.get(i).time) <= 60) {
                        res.add(ts.get(i).toString());
                        break;
                    }
                }
            }
        }
        return res;
    }

    class Tran {
        String name, city;
        int time, amount;

        Tran(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }
}
