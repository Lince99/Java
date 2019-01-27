/*
 * Creare classe Pila "contenente oggetti" Studenti e utilizzarla,
 * la classe deve prevedere la creazione di un struttura PILA,
 * inserire prima gli studenti e poi eliminare tutti gli elementi
 * e restituire  la stampa delle età di tutti gli studenti
 * che vanno eliminati a partire dal TOP
 */

import java.util.*;

public class ListaStudenti
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);

        //creazione Pila
        Pila corsa = new Pila();
        //Inserimento di studenti vari
        corsa.push(new Studente("Mario", "Rossi", 30));
        corsa.push(new Studente("Luigi", "Verdi", 12));
        corsa.push(new Studente("Genoveffo", "Matumba", 50));
        corsa.push(new Studente("Luisa", "Rossi", 48));
        corsa.push(new Studente("Susanna", "Teolo", 69));
        corsa.push(new Studente("Francesco", "Pluto", 29));
        corsa.push(new Studente("Pippo", "Von Einz", 71));
        //stampa e rimozione studenti
    }
}
