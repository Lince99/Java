import java.util.*;
import java.io.*;
import java.net.*;

public class MulticastReceiver {
    protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];
    private int port;
    private String ip_group = "255.255.255.0";
    
    public MulticastReceiver(int port) {
		this.port = port;
	}
	
	public MulticastReceiver(int port, String gr) {
		this.port = port;
		this.ip_group = gr;
	}
 
    public void connect() {
		try {
			socket = new MulticastSocket(this.port);
			InetAddress group = InetAddress.getByName(ip_group);
			socket.joinGroup(group);
			while (true) {
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String received = new String(packet.getData(), 0, packet.getLength());
				if ("end".equals(received)) {
					break;
				}
			}
			socket.leaveGroup(group);
			socket.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
}
