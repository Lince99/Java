/*
 * esempio preso dal libro a pagina 158-159
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientMessaggio {
	
	private static int portaServer = 2345;
	private static String serverAddress = "localhost";
	private static int buffer_size = 1024;

    public static void main(String args[]) throws Exception {
		boolean attivo = true;
		InetAddress IPServer = InetAddress.getByName(serverAddress);
        byte[] bufferIN = new byte[buffer_size];
		byte[] bufferOUT = new byte[buffer_size];
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		
		
		//gestice CTRL+C
		Runtime.getRuntime().addShutdownHook(
			new Thread() {
				@Override
				public void run() {
					System.out.println("\nCTRL+C rilevato ...");
					return;
				}
			}
		);
		
		while(attivo) {
			System.out.println("Client pronto - inserisci un dato da inviare:");
			String daSpedire = input.readLine();
			bufferOUT = daSpedire.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPServer, portaServer);
			clientSocket.send(sendPacket);
			
			DatagramPacket receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
			clientSocket.receive(receivePacket);
			String ricevuto = new String(receivePacket.getData());
			
			int numCaratteri = receivePacket.getLength();
			ricevuto = ricevuto.substring(0, numCaratteri);
			System.out.println("String ricevuta dal server: "+ricevuto);
			if(ricevuto.equals("FINE")) {
				System.out.println("Client in chiusura .");
				attivo = false;
			}
		}
		clientSocket.close();
    }
}
