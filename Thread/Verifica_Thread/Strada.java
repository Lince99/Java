/*
 * Basso Nicola
 * 4^AI
 * 30/04/2019
 */
/*
 * Classe contenente la variabile condivisa
 */

import java.util.concurrent.Semaphore;

public class Strada {
	
	//mutex per garantire l'accesso esclusivo al ponte
	Semaphore mutex = new Semaphore(1);
	
	private int lunghezza;
	private boolean verso; //true = corsia destra, false = corsia sinistra
	
	public Strada(int lung) {
		this.verso = true;
		this.lunghezza = lung;
	}
	
	public int getLunghezza() {
		return this.lunghezza;
	}
	
	//passa ai veicoli l'informazione in modo esclusivo
	public boolean getVerso() {
		boolean v = false;
		try {
			mutex.acquire();
			v = this.verso;
		} catch(InterruptedException e) {
            System.out.println("Interrupt Error!");
        }
        mutex.release();
		return v;
	}
	
	//cambia il verso del ponte (eseguito dal main)
	public synchronized void setVerso(boolean v) {
		try {
			mutex.acquire();
			this.verso = v;
			//notifica a tutte le auto che c'e' stato il cambio
			notifyAll();
		} catch(InterruptedException e) {
            System.out.println("Interrupt Error!");
        }
        mutex.release();
	}
	
	//stampa le informazioni sul ponte
	public void printState() {
		System.out.print("Il ponte e' lungo " + this.lunghezza + "km ");
		System.out.print("ed attualmente e' percorso ");
		if(this.verso)
			System.out.println("dalla corsia destra");
		else
			System.out.println("dalla corsia sinistra");
	}
}
