import java.util.HashMap;
import java.util.Map;

public class MostPopularCanteenOrder {
    static void mostPopular(String[] orders) {
        Map<String, Integer> count = new HashMap<>();

        for (String item : orders) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        String best = orders[0];
        int max = count.get(best);

        for (String item : orders) {
            if (count.get(item) > max) {
                best = item;
                max = count.get(item);
            }
        }

        System.out.println("(\"" + best + "\", " + max + ")");
    }

    public static void main(String[] args) {
        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        mostPopular(orders);

        String[] orders2 = {
            "tea", "coffee", "coffee", "tea"
        };

        mostPopular(orders2);
    }
}

//Complexity: Expected time \(O(n)\); auxiliary space \(O(u)\), 
//where u is the number of distinct items.