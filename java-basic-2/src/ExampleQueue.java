import java.util.PriorityQueue;
import java.util.Queue;

public class ExampleQueue {
    public static void main(String[] args) {
        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(5);
        numbers.add(2);

        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll()); // 最小の要素から出力
        }
    }
}


