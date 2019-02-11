/*
 * Basso Nicola
 * 4^AI
 * 04/02/2019
 */
/*
 * creazione di una struttura dati ad albero binario
 */

package Alberi;

import java.util.Scanner;

public class AlberoBinario {

    private NodoAlbero root;

    public AlberoBinario() {
        this.root = null;
    }
    public AlberoBinario(NodoAlbero node) {
        this.root = node;
    }

    public void setRoot(NodoAlbero node) {
        this.root = node;
    }
    public NodoAlbero getRoot() {
        return this.root;
    }

    public void printNodo(NodoAlbero root) {

        if(root == null) {
            System.out.println("Nessuno nodo presente!");
            return;
        }
        else
            System.out.print("Nodo corrente: "+root.getValue());
        if(root.getSx() != null)
            System.out.print("\tSX: "+root.getSx().getValue());
        if(root.getDx() != null)
            System.out.print("\tDX: "+root.getDx().getValue());
        System.out.print("\n");

    }

    /*
     * metodo che richiede iterativamente di inserire i nodi dell'albero
     */
    public void fillTree(NodoAlbero node) {
        Scanner reader = new Scanner(System.in);
        NodoAlbero current = node;
        int scelta = 0;

        do {
            printNodo(node);
            System.out.println("1 - Se si vuole cambiare il valore del nodo attuale");
            System.out.println("2 - Se si vuole passare alla foglia sinistra");
            System.out.println("3 - Se si vuole passare alla foglia destra");
            System.out.println("4 - Ritorna alla radice del nodo corrente");
            System.out.println(" 0- Termina l'inserimento");
            do {
                try {
                    scelta = reader.nextInt();
                } catch(Exception e) {
                    scelta = -1;
                }
            } while(scelta < 0 || scelta > 4);
            switch(scelta) {
                case 1:
                    System.out.print("\tInserisci il valore: ");
                    node.setValue(reader.next().charAt(0));
                    break;
                case 2:
                    current = node;
                    node = node.getSx();
                    break;
                case 3:
                    current = node;
                    node = node.getDx();
                    break;
                case 4:
                    System.out.print("Ritorno a ");
                    printNodo(current);
                    node = current;
                    break;
                default:
                    break;
            }
        } while(scelta != 0);

    }

    /*
     * metodo che aggiunge una foglia a sinistra della radice
     * con valore root_val
     */
    public void addLeafSx(char root_val, char leaf_val) {

        NodoAlbero node = null;
        NodoAlbero current = null;

        node = new NodoAlbero(leaf_val);
        current = new NodoAlbero();
        //se non esiste una radice il nodo creato lo diventa
        if(root == null) {
            setRoot(node);
            return;
        }
        //altrimenti effettua la ricerca del valore root_val
        current = cercaNodo(getRoot(), root_val);
        //e assegna il nodo come foglia
        if(current != null) {
            if(current.getSx() != null)
                System.out.println("Nodo gia' presente! ("+
                                   current.getSx().getValue()+")");
            current.setSx(node);
        }
        else
            System.out.println("Nodo "+root_val+" non trovato!");

    }

    /*
     * metodo che aggiunge una foglia a destra della radice
     * con valore root_val
     */
    public void addLeafDx(char root_val, char leaf_val) {
        NodoAlbero node = null;
        NodoAlbero current = null;

        node = new NodoAlbero(leaf_val);
        current = new NodoAlbero();
        //se non esiste una radice il nodo creato lo diventa
        if(root == null) {
            setRoot(node);
            return;
        }
        //altrimenti effettua la ricerca del valore root_val
        current = cercaNodo(getRoot(), root_val);
        //e assegna il nodo come foglia
        if(current != null) {
            if(current.getDx() != null)
                System.out.println("Nodo gia' presente! ("+
                                   current.getDx().getValue()+")");
            current.setDx(node);
        }
        else
            System.out.println("Nodo "+root_val+"non trovato!");

    }

    /*
     * metodo di ricerca ricorsiva seguendo la regola del pre-order
     */
    private NodoAlbero cercaNodo(NodoAlbero root, char val) {
        NodoAlbero node = null;

        if(root == null)
            return null;
        //ho trovato il nodo con il valore
        if(root.getValue() == val)
            return root;
        //visito la foglia sinistra
        if(root.getSx() != null)
            node = cercaNodo(root.getSx(), val);
        //visito la foglia destra
        if(root.getDx() != null)
            node = cercaNodo(root.getDx(), val);

        return node;
    }

    /*
     * metodo di stampa ricorsiva seguendo la regola del pre-order
     */
    public void visita_PreOrder(NodoAlbero root) {

        if(root == null)
            return;
        //stampa radice
        System.out.print(root.getValue()+", ");
        //stampa foglia sinistra
        if(root.getSx() != null)
            visita_PreOrder(root.getSx());
        //stampa foglia destra
        if(root.getDx() != null)
            visita_PreOrder(root.getDx());

    }

    /*
     * metodo di stampa ricorsiva seguendo la regola del in-order
     */
    public void visita_InOrder(NodoAlbero root) {

        if(root == null)
            return;
        //stampa foglia sinistra
        if(root.getSx() != null)
            visita_InOrder(root.getSx());
        //stampa radice
        System.out.print(root.getValue()+", ");
        //stampa foglia destra
        if(root.getDx() != null)
            visita_InOrder(root.getDx());

    }

    /*
     * metodo di stampa ricorsiva seguendo la regola del post-order
     */
    public void visita_PostOrder(NodoAlbero root) {

        if(root == null)
            return;
        //stampa foglia sinistra
        if(root.getSx() != null)
            visita_PostOrder(root.getSx());
        //stampa foglia destra
        if(root.getDx() != null)
            visita_PostOrder(root.getDx());
        //stampa radice
        System.out.print(root.getValue()+", ");

    }


    /*
     * metodo che ritorna la somma dei valori contenuti in tutti i nodi
     */
    public int sommaNodi(NodoAlbero root) {
        int somma = 0;

        if(root == null)
            return somma;
        somma += root.getValue();
        if(root.getSx() != null)
            somma += sommaNodi(root.getSx());

        return somma;
    }

    /*
     * metodo che ritorna true nel caso trovi il valore richiesto
     */
    public boolean cercaIterativa(char val) {
        NodoAlbero tmp = root;
        NodoAlbero oldRoot = root;

        if(tmp == null)
            return false;
        //TODO USARE LO STACK PER RICERCA ITERATIVA
        while(tmp != null) {
            if(tmp.getValue() == val)
                return true;

        }


        /*else {
            //salva la radice per entrare nelle foglie
            oldRoot = tmp;
            if(tmp.getSx() != null)
                tmp = tmp.getSx();
            if(tmp.getDx() != null)
                tmp = tmp.getDx();
        }*/

        return false;
    }
}
