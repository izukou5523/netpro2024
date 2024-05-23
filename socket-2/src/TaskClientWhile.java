import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        try {
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            
            while (true) {
                System.out.print("計算する数値を入力してください → ");
                int number = scanner.nextInt();

                if (number <= 1) {
                    System.out.println("1以下の値が入力されたのでクライアントを終了します");
                    break;
                }

                System.out.println("localhostの" + port + "番ポートに接続を要求します");
                Socket socket = new Socket("localhost", port);
                System.out.println("接続されました");

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                TaskObject task = new TaskObject();
                task.setExecNumber(number);
                oos.writeObject(task);
                oos.flush();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                TaskObject resultTask = (TaskObject) ois.readObject();
                System.out.println("サーバからの最大素数は " + resultTask.getResult());

                ois.close();
                oos.close();
                socket.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        } finally{
            scanner.close();
        }
    }
}

