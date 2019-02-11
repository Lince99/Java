/*
* Basso Nicola
* 4^AI
* 19/09/2018
* last update: 20/09/2018
*/
/*
* Classe dedita a testare le classi create 
* riguardante la gesione di dati di persone
*/
package people;

import java.util.Scanner;

/**
 *
 * @author s01118
 */
public class People
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Persona umano = new Persona();
        
        //chiede all'utente di inserire i dati di una persona
        System.out.println("Inserisci i seguenti dati personali: ");
        System.out.print("Nome:\t");
        umano.setNome(sc.nextLine());
        System.out.print("Cognome:\t");
        umano.setCognome(sc.nextLine());
        System.out.print("Data di nascita:\t");
        umano.setData_nascita(sc.nextLine());
        System.out.print("Sesso (0= femmina, 1=maschio, 2=non definito):\t");
        umano.setSesso(sc.nextInt());
        //stampa a video i dati salvati nell'oggetto
        System.out.print("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.println(umano.getNome()+" "+umano.getCognome()+":");
        System.out.println("E' nato il "+umano.getData_nascita());
        System.out.print("ed e' ");
        switch (umano.getSesso())
        {
            case 0:
                System.out.println("una femmina.");
                break;
            case 1:
                System.out.println("un maschio.");
                break;
            default:
                System.out.println("appartenente a un sesso non ben definito.");
                break;
        }
    }
    
}
