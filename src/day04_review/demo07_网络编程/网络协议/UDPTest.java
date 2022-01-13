package day04_review.demo07_网络编程.网络协议;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPd协议的网络编程
 *
 * @program: test
 * @author: chasion
 * @create: 2022-01-13 21:48
 */
public class UDPTest {

    // 发送端
    @Test
    public void sender(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str = "send message";
            byte[] buffer = str.getBytes();

            InetAddress inet = InetAddress.getByName("127.0.0.1");

            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, inet, 8899);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert socket != null;
            socket.close();
        }
    }

    // 接收端
    @Test
    public void receiver(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8899);
            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert socket != null;
            socket.close();
        }


    }
}
