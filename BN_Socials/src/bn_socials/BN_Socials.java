/*
 * Basso Nicola
 * 4^AI
 * 22/10/2018
 */
 /*
 * Verifica di Informatica laboratorio su OOP
 */
package bn_socials;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author s01118
 */
public class BN_Socials {
    
    //attributes
    private static String username;
    private static String password;
    private static String cell;

    
    
    /**
     * @param args comandi passati dalla CLI
     */
    public static void main(String[] args) {
        //presentazione del programma
        System.out.println("Benvenuto nel programma di test dei social!");
        System.out.println("Inserisci i seguenti dati:");
        //richiesta dei dati base
        username = inputUser("l'username");
        password = inputUser("la password");
        
        //creazione di 3 account social
        Facebook fbAccount = new Facebook(username, password);
        Instagram instaAccount = new Instagram(username, password);
        Twitter twitAccount = new Twitter(username, password);
        
        //inserimento a scelta degli altri dati
        System.out.println("Inserisci il numero di cellulare dell'account facebook:");
        cell = inputUser("il cellulare");
        fbAccount.setTelefono(cell);
        System.out.println("Inserisci il numero di cellulare dell'account instagram:");
        cell = inputUser("il cellulare");
        instaAccount.setTelefono(cell);

        //stampa delle informazioni di tutti e 3
        System.out.println("\nStampa delle informazioni dei seguenti account:");
        System.out.println("\tAccount Facebook:\n"+fbAccount.asString());
        System.out.println("\tAccount Instagram:\n"+instaAccount.asString());
        System.out.println("\tAccount Twitter:\n"+twitAccount.asString());
    }
    
    
    
    //methods
    /**
     * 
     * @param frase Stringa che descrive cosa deve inserire l'utente
     * @return ritorna la stringa inserita, opportunamente controllata
     */
    private static String inputUser(String frase) {
        boolean check = true; //flag di controllo per un input corretto
        Scanner in = new Scanner(System.in);
        String input = new String("");
        
        do {
            System.out.println("Inserisci "+frase+" dell'account:");
            //controllo che non ci siano caratteri speciali che darebbero errore
            try {
                input = in.nextLine();
                //l'utente deve per forza inserire qualcosa
                if(input.isEmpty()) {
                    System.out.print("Non hai inserito alcun carattere!\nRe-");
                    check = true;
                }
                //se e' tutto valido allora smette di fare il ciclo
                else {
                    check = false;
                }
            } catch(InputMismatchException inE) {
                System.out.print("Inserimento errato!\nRe-");
                check = true;
            }
        } while(check);
        
        return input;
    }
}
