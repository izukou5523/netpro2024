import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddress {

    public static void main(String[] args) {
        try {

            // IP Address
            InetAddress addr = InetAddress.getByName("8.8.8.8");
            // Host name
            System.out.println("Host name is: "
                    + addr.getHostName());
            // Host Address
            System.out.println("Ip address is: "
                    + addr.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("エラー: ローカルホストのIPアドレスを取得できません。");
            e.printStackTrace();
        }
    }
}

// ipの調べ方 ターミナルで以下のコマンド
// >ipconfig
// >ifconfig
