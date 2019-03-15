/*
 * Basso Nicola 4^AI
 * Programma in java che data un'espressione via codice ne calcola
 * il risultato con l'utilizzo di thread
 *				(a+b)*c		 a
 * risultato = --------- * -----
 *				   b		 c
 */

import java.util.Scanner;

public class Espressioni_thread
{
	public static void main(String [] args)
    {
        double a = 0;
        double b = 0;
        double c = 0;
        double risultato = 0;
        
        //chiede i dati all'utente
        a = getDouble("Inserisci il valore di A:");
        b = getDouble("Inserisci il valore di B:");
        c = getDouble("Inserisci il valore di C:");
        
        Calculation calcs = new Calculation();
        
        System.out.println("TOTALE: "+risultato);
    }
    
    /*
     * Richiede all'utente di inserire un numero con virgola
     */ 
    private static double getDouble(String request) {
		Scanner in = new Scanner(System.in);
		boolean checkIn = true;
		double x = 0;
		
		do {
			System.out.println(request);
			try {
				x = in.nextDouble();
			} catch(Exception e) {
				checkIn = false;
			}
		} while(!checkIn); 
		
		return x;
	}
}

class Calculation implements Runnable {
	
	public Calculation(int flag) {
		switch(flag) {
			case 0:
				//espressione
				break;
			case 1:
				//somma
				break;
			case 2:
				//sottrazione
				break;
			case 3:
				//moltiplicazione
				break;
			case 4:
				//divisione
				break;
			case 5:
				//potenza
				break;
			default:
				break;
		}
	}
	
	public void run() {
		
	}
}
