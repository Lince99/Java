/*
 * Basso Nicola
 * 4^AI
 * 30/04/2019
 */

/*
 * 1) Una strada trafficata passa sopra ad un fiume, 
 * 	  ma il ponte è stretto e va regolato 
 * 	  con un senso unico alternato.
 * 	  Alle estremità del ponte vi sono dei sensori 
 *    che rilevano la presenza o meno di autoveicoli in attesa.
 * 
 * Scrivere un software in Java che permetta 
 * di regolare il traffico [3] nel migliore dei modi. [1].
 * 
 * Simulare poi il transito di veicoli 
 * e testare il software stampando a video la situazione 
 * ad ogni mutamento. [1,5]
 * 
 * Commentare in modo da rendere il codice chiaro 
 * anche ai non esperti di programmazione concorrente 
 * e ai non conoscitori del linguaggio Java [1].
 * 
 * E' possibile utilizzare la classe semaforo utilizzata 
 * per risolvere gli esercizi proposti durante 
 * le lezioni in laboratorio.
 * 
 * Rispondere alle seguenti domande, 
 * come commento in calce al file contenente la classe principale:
 * 
 * 2) Cosa si intende con i termini deadlock e starvation? [1]
 * 3) Che differenza c'è tra "notify" e "notifyall" in Java? [1]
 * 4) Consegnare i sorgenti in una cartella chiamata 
 * 	  ProprioCognome.7z nei limiti di tempo prefissati* [1]
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static Random rand_gen;
	public static void main(String[] args) {
		//dati usati nella creazione di veicoli
		int lunghezza = 0;
		int n_veicoli = 0;
		String nome_auto = new String();
		int velocita = 0;
		int max_speed = 50;
		int min_speed = 10;
		int verso = 0;
		boolean ponte_state = true;
		Scanner scan = new Scanner(System.in);
		rand_gen = new Random();
		
		//richiede i dati
		System.out.println("Inserisci la lunghezza del ponte:");
		lunghezza = scan.nextInt();
		System.out.println("Inserisci il numero di veicoli:");
		n_veicoli = scan.nextInt();
		
		//crea la risorsa condivisa
		Strada ponte = new Strada(lunghezza);
		
		//crea n veicoli che percorreranno il ponte
		for(int i = 0; i < n_veicoli; i++) {
			nome_auto = "Auto#"+i;
			velocita = rand_gen.nextInt()%max_speed+min_speed;
			verso = rand_gen.nextInt()%2;
			if(verso == 1)
				ponte_state = true;
			else
				ponte_state = false;
			//crea e stampa le informazioni del veicolo creato
			new Veicolo(nome_auto, velocita, ponte_state, ponte).printState();
			//cambia la direzione percorribile del ponte
			ponte_state = ponte.getVerso();
			if(i%2 == 0)
				ponte.setVerso(!ponte_state);
			ponte.printState();
		}
	}
}

/*
 * Risposte alle domande:
 * 
 * 2) Il deadlock e' una stato di un insieme di processi tra i quali 
 * 	  uno o piu' processi non possono ottenere tutte le risorse 
 *    necessarie alla prosecuzione del programma poiche' gia' 
 *    occupate da altri processi i quali a loro volta necessitano 
 *    di altre risorse per continuare.
 * 	  La starvation e' lo stato di un processo il quale rimane in 
 *    attesa per un tempo indefinito senza mai ottenere la risorsa, 
 *    spesso causato da una priorita' troppo bassa.
 * 
 * 3) Notify in Java serve a notificare all'ultimo thread messo 
 *    in attesa con il metodo wait che puo' proseguire la sua 
 *    esecuzione, mentre notifyAll serve a notificare a tutti i 
 *    processi in stato di wait che possono proseguire.
 * 
 */
