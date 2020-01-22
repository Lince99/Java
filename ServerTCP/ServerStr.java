/*
 * esempio preso dal libro a pagina 138
 * fonti:
 * https://stackoverflow.com/questions/2541597/how-to-gracefully-handle-the-sigkill-signal-in-java
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket attendi() {
        int porta = 6789;

        try {
            System.out.println("SERVER partito in esecuzione ...");
            //creo un server sulla porta 6789
            server = new ServerSocket(porta);
            //rimane in attesa di un client
            client = server.accept();
            //chiudo il server per inibire altri client
            server.close();
            //associo due oggetti al socket del client per effettuare la scrittura e la lettura
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return client;
    }

    public void comunica() {
		do {
			try {
				//rimango in attesa della riga trasmessa dal client
				System.out.println("Benvenuto client, scrivi una frase e la trasformo in maiuscola. Attendo ...");
				stringaRicevuta = inDalClient.readLine();
				//gestice CTRL+D
				if(stringaRicevuta != null) {
					System.out.println("Ricevuta la stringa dal client : "+stringaRicevuta);
					//la modifico e la spedisco al client
					stringaModificata = stringaRicevuta.toUpperCase();
					System.out.println("Invio la stringa modificata al client ...");
					try {
						outVersoClient.writeBytes(stringaModificata+'\n');
					} catch(SocketException e) {
						System.out.println("Client disconnesso con CTRL+D ...");
						client.close();
						System.exit(0);
					}
				}
				else {
					System.out.println("EOF ricevuto, chiusura connessione ...");
					//termina elaborazione sul server : chiudo la connessione del client
					System.out.println("SERVER: fine elaborazione ...");
					client.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while(stringaRicevuta != null);
    }

    public static void main(String args[]) throws InterruptedException {
		ServerStr servente = new ServerStr();
        
        servente.attendi();
        //attende client successivi
        while(true) {
			//gestice CTRL+C
			Runtime.getRuntime().addShutdownHook(
				new Thread() {
					@Override
					public void run() {
						System.out.println("\nCTRL+C rilevato ...");
					}
				}
			);
            servente.comunica();
        }
    }
}
