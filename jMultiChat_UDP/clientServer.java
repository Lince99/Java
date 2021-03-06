/*
 * clientServer.java
 *
 * Copyright 2020 Laykeen <s01118@lab4-pc11>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

/*
 * 1. Server avviato in ascolto di multi connessioni
 * 2. Avvio client:
 *    2.1. Invio messaggi in broadcast se non viene selezionato un server
 *    2.2. Connessione al server esterno se l'IP viene fornito
 * 3. Client invia messaggio UDP del formato:
 *    ---> <id timeout=30  value=nomeClient>
 *        <msg id=1>
 *            contenuto
 * 		  </msg>
 *    </id>  <----
 */

import java.io.*;
import java.net.*;
import java.util.*;


public class clientServer {
	//private String CHAT_BLUE = "\e[34;0m";
	//private String CHAT_VIOLET = "\e[95;0m";

	private static int port = 2345;

	public static void main (String args[]) {
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

		avviaServer();
		avviaClient();
	}

	public int avviaServer() {
		//avvia thread
		ServerChat server = new ServerChat();
		server.run();

		return 0;
	}

	public int avviaClient() {

	}
}

class ServerChat implements Runnable {
	private int max_connections = 20;
	private ArrayList<ClientObj> client_list;
	private DatagramSocket serverSocket;
	private static int buffer_size = 1024;
	private int port = 2345;


	public void ServerChat(int max, ClientObj lista) {
		this.max_connections = max;
		this.client_list = new ArrayList<ClientObj>();
	}

	public void ServerChat(int porta) {
		//bind sel socket
		try{
			this.serverSocket = new DatagramSocket(this.port);
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.client_list = new ArrayList<ClientObj>();
		this.port = porta;
	}

	public void run() {
		boolean attivo = true;
		//si connettono vari client
		while(attivo) {
			String end = receive();
			if(end.equals("fine")) {
				System.out.println("Server in chiusura .");
				attivo = false;
			}
		}
		serverSocket.close();
	}

	public String receive() {
		byte[] bufferIN = new byte[buffer_size];
		byte[] bufferOUT = new byte[buffer_size];

		//riceve dati dai client
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

		return ricevuto;
	}
}

class ClientChat implements Runnable {
	public ClientChat() {

	}

	public void run() {

	}
}

class ClientObj {
	private int id;
	private int timeout;
	private int port_server;

	public ClientObj() {
		this.id = 0;
		this.timeout = 30;
		this.port_server = 8080;
	}
	public ClientObj(int id, int port) {
		this.id = id;
		this.timeout = 30;
		this.port_server = port;
	}

	public int get_id() {
		return this.id;
	}
}
