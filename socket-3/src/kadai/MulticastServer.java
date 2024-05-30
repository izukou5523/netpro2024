package kadai;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345;

            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);

            System.out.println("Server started. Waiting for commands...");

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                multicastSocket.receive(packet);
                String receivedMessage = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + receivedMessage);

                // クライアントに応答を送信
                String response = "Command received: " + receivedMessage;
                byte[] responseBuffer = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length, packet.getAddress(), packet.getPort());
                DatagramSocket responseSocket = new DatagramSocket();
                responseSocket.send(responsePacket);
                responseSocket.close();

                // 終了コマンドのチェック
                if (receivedMessage.contains("EXIT")) {
                    System.out.println("Exit command received. Shutting down server.");
                    break;
                }
            }

            multicastSocket.leaveGroup(group);
            multicastSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

