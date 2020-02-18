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

//https://stackoverflow.com/questions/2950715/udp-broadcast-in-java
//https://www.baeldung.com/java-broadcast-multicast

/*
 * Il client invia messaggio UDP del formato:
 *    ---> <id timeout=30  value=nomeClient>
 *        <msg id=1>
 *            contenuto
 * 		  </msg>
 *    </id>  <----
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {

    // private String clientID = new String("");
    // private DatagramSocket udpSocket;
    // private InetAddress serverAddress;
    // private int serverPort = 8888;
    // private Scanner scanner = new Scanner(System.in);

    private DatagramSocket clientSocket;


    public static void main(String[] args) {
        //gestice CTRL+C
        Runtime.getRuntime().addShutdownHook(
            new Thread() {
                @Override
                public void run() {
                    System.out.println("\nCTRL+C rilevato ...");
                    this.clientSocket.close();
                    return;
                }
            }
        );

        // else {
        //     System.out.println("Need "+args[0]+" [ID] [SERVER IP] [SERVER PORT]...");
        //     return;
        // }


        int timeout = 60;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        clientSocket = new DatagramSocket();
        clientSocket.setBroadcast(true);
        InetAddress IPAddress = InetAddress.getByName("localhost");
        while(true) {
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            String sentence = inFromUser.readLine();
            String msg = "<msg id=\"Laykeen\" timeout=\""+timeout+"\">"+sencence+"</msg>";
            sendData = msg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), 9876);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + modifiedSentence);
            sleep(timeout);
            clientSocket.close();
        }

    }
}
