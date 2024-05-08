import java.util.HashSet;
import java.util.Set;

public class ExampleSet {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<>();
        countries.add("Japan");
        countries.add("USA");
        countries.add("France");
        countries.add("Japan"); // 重複不可

        for (String country : countries) {
            System.out.println(country);
        }
    }
}

