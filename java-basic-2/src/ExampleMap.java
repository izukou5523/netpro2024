import java.util.HashMap;
import java.util.Map;

public class ExampleMap {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();
        stock.put("Apple", 50);
        stock.put("Banana", 30);
        stock.put("Cherry", 20);

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

