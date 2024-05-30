package kadai;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345;

            DatagramSocket socket = new DatagramSocket();
            String clientId = "Client1";
            String command = "SOME_COMMAND";

            String message = clientId + ": " + command;
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Command sent: " + message);

            // サーバーからの応答を受信
            byte[] responseBuffer = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("サーバーからの応答: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

