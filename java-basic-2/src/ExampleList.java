import java.util.ArrayList;
import java.util.List;

public class ExampleList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana"); // 重複を許す

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

