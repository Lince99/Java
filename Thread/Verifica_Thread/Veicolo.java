/*
 * Basso Nicola
 * 4^AI
 * 30/04/2019
 */
/*
 * Classe veicolo composta dal thread che dovra' percorrere il ponte
 */

public class Veicolo implements Runnable {
	
	Strada strada; //risorsa in comune con gli altri veicoli
	private String marca; //dato da stampare (nome univoco)
	int velocita; //Velocita' = Spazio / Tempo
	boolean corsia; //true = destra, false = sinistra
	boolean in_wait; //stato del veicolo
	
	public Veicolo(String m, int vel, boolean senso, Strada ponte) {
		this.marca = m;
		this.velocita = vel;
		this.corsia = senso;
		this.strada = ponte;
		this.in_wait = false;
		//avvia il thread
		new Thread(this, this.marca).start();
	}
	
	//metodo usato dal thread appena viene avviato
	public synchronized void run() {
		int tempo = 0;
		
		//cerca di entrare
		while(this.strada.getVerso() != this.corsia) {
			try {
				wait(10);
			} catch(InterruptedException e) {
				System.out.println("Error on wait!");
			}
			this.in_wait = true;
		}
		this.in_wait = false;
		//percorre il ponte nella sua corsia
		try {
			//TODO fix math
			tempo = (int) (this.strada.getLunghezza() / this.velocita);
		} catch(IllegalArgumentException e) {
			tempo = 10;
		}
		try {
			Thread.sleep(tempo*100);
		} catch(InterruptedException e) {
			System.out.println("Error on sleep!");
		}
	}
	
	//stampa le informazioni del veicolo
	public void printState() {
		//se e' in attesa avvisa l'utente
		if(this.in_wait) {
			System.out.println(marca + " sta attendendo");
			return;
		}
		//altrimenti mostra le informazioni
		System.out.print(marca + " sta attraversando il ponte ");
		if(corsia)
			System.out.print("dalla corsia destra ");
		else
			System.out.print("dalla corsia sinistra ");
		System.out.println("a " + this.velocita + " km/h");
	}
}
