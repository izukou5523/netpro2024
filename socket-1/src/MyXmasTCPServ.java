import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class MyXmasTCPServ {

    private static int count; // クラス変数として定義

    private static int getRandomCount() {
        Random random = new Random();
        return random.nextInt(10) + 1; // 1から10のランダムな数
    }

    private static String serverProcess(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("🎁");
        for (int i = 0; i < count; i++) {
            sb.append(content);
        }
        sb.append("🎁");
        String result = sb.toString();
        return result;
    }

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in, "UTF-8");
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            MyXmasPresent present = (MyXmasPresent) ois.readObject();// Integerクラスでキャスト。

            String msgPresent = present.getMessage();
            System.out.println("メッセージは" + msgPresent);
            String presentFromClient = present.getContent();
            System.out.println("プレゼントの内容は" + presentFromClient);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            count = getRandomCount();
            MyXmasPresent response = new MyXmasPresent();
            response.setMessage("、「メリクリ！」\n" + presentFromClient + "ありがとう。\nプレゼントのお返しは" + count + "個" + "です");
            response.setContent(serverProcess(presentFromClient));

            oos.writeObject(response);
            oos.flush();

            // close処理

            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
