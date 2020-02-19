import java.util.*;
import java.net.*;
import java.io.*;

public class Multicast {
	public static void main(String args[]) {
		//gestice CTRL+C
        Runtime.getRuntime().addShutdownHook(
            new Thread() {
                @Override
                public void run() {
                    System.out.println("\nCTRL+C rilevato ...");
                    System.exit(0);
                }
            }
        );
		int port = 2345;
		String group = new String("230.0.0.0");
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		String username = new String("lab4-pc11");
		int timeout = 60;
		
		System.out.println("Avvio del server...");
		Thread serverThread = new Thread() {
			public void run() {
				MulticastReceiver receiver = new MulticastReceiver(port, group);
				receiver.connect();
			}
		};
		
		System.out.println("Avvio del client...");
		//Thread clientThread = new Thread() {
		//	public void run() {
				while(true) {
					String sentence = new String("");
					try {
						System.out.println("Inserisci il messaggio da inviare in multicast:");
						sentence = inFromUser.readLine();
					} catch(IOException te) {
						te.printStackTrace();
						System.exit(1);
					}
					String msg = "<msg id=\""+username+"\" timeout=\""+timeout+"\">"+sentence+"</msg>";
					System.out.println("Messaggio inviato: "+msg);
					MulticastPublisher publisher = new MulticastPublisher(port, group);
					try {
						publisher.multicast(msg);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
		//	}
		//};
	}
}
