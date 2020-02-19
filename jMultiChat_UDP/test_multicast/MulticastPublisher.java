import java.util.*;
import java.io.*;
import java.net.*;

public class MulticastPublisher {
    private DatagramSocket socket;
    private InetAddress group;
    private String group_str = "255.255.255.0";
    private int port;
    private byte[] buf;
    
    public MulticastPublisher(int port, String gr) {
		this.group_str = gr;
		this.port = port;
	}
 
    public void multicast(String multicastMessage) throws IOException {
        socket = new DatagramSocket();
        group = InetAddress.getByName(group_str);
        buf = multicastMessage.getBytes();
 
        DatagramPacket packet 
          = new DatagramPacket(buf, buf.length, group, 4446);
        socket.send(packet);
        socket.close();
    }
}
