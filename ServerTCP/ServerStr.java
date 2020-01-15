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
        try {
            //rimango in attesa della riga trasmessa dal client
            System.out.println("Benvenuto client, scrivi una frase e la trasformo in maiuscola. Attendo ...");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("Ricevuta la stringa dal client : "+stringaRicevuta);
            //la modifico e la spedisco al client
            stringaModificata = stringaRicevuta.toUpperCase();
            System.out.println("Invio la stringa modificata al client ...");
            outVersoClient.writeBytes(stringaModificata+'\n');
            //termina elaborazione sul server : chiudo la connessione del client
            System.out.println("SERVER: fine elaborazione ...");
            client.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ServerStr servente = new ServerStr();
        while(true) {
            servente.attendi();
            servente.comunica();
        }
    }
}
