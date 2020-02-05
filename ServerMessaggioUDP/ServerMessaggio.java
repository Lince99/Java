/*
 * esempio preso dal libro a pagina 157-158
 * fonti:
 * https://stackoverflow.com/questions/2541597/how-to-gracefully-handle-the-sigkill-signal-in-java
 * https://www.geeksforgeeks.org/java-net-datagrampacket-class-java/
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerMessaggio {

	private static int porta = 2345;
	private static int buffer_size = 1024;

    public static void main(String args[]) throws Exception {

        if(args.length > 0)
            this.porta = Integer.parseInt(args[0]);
		DatagramSocket serverSocket = new DatagramSocket(porta);
		boolean attivo = true;
		byte[] bufferIN = new byte[buffer_size];
		byte[] bufferOUT = new byte[buffer_size];
		
		System.out.println("Avvio del server ...");
		
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
		
        //attende client successivi
        while(attivo) {
			DatagramPacket receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
			serverSocket.receive(receivePacket);
			
			String ricevuto = new String(receivePacket.getData());
			int numCaratteri = receivePacket.getLength();
			ricevuto = ricevuto.substring(0, numCaratteri);
			System.out.println("Ricevuta la stringa: "+ricevuto);
			
			InetAddress IPClient = receivePacket.getAddress();
			int portaClient = receivePacket.getPort();

			
			String daSpedire = ricevuto.toUpperCase();
			bufferOUT = daSpedire.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
			serverSocket.send(sendPacket);
			
			if(ricevuto.equals("fine")) {
				System.out.println("Server in chiusura .");
				attivo = false;
			}
        }
        serverSocket.close();
    }
}
