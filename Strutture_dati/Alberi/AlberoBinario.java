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
     * metodo che ritorna il numero di occorrenze del valore richiesto
     */
    public int cercaConta(NodoAlbero nodo, char val) {
        int add = 0;
        
        if(nodo == null)
            return 0;
        if(nodo.getValue() == val)
            add++;
        if(nodo.getSx() != null)
            add += cercaConta(nodo.getSx(), val);
        if(nodo.getDx() != null)
            add += cercaConta(nodo.getDx(), val);

        return add;
    }
    
    /*
     * metodo che controlla se due alberi hanno la stessa struttura (no valori)
     */
    public boolean stessaStruttura(NodoAlbero p1, NodoAlbero p2) {
        
        if(p1 == null && p2 == null)
            return true;
        if(p1 == null || p2 == null)
            return false;
        
        return stessaStruttura(p1.getSx(), p2.getSx()) &&
               stessaStruttura(p1.getDx(), p2.getDx());
    }
    
    /* 
     * metodo che popola l'albero iterativamente con valori ordinati
     */
    public void fillOrdinato(char[] val) {
        int i = 0;
        NodoAlbero current = null;
        NodoAlbero prev = null;
        boolean flag = false;
        
        if(val.length <= 0)
            return;
        //se non e' presente la radice la crea
        if(this.root == null)
            root = new NodoAlbero();
        
        //la radice prende il primo valore
        root.setValue(val[i]);
        current = root;
        //per i successivi 
        for(i = 1; i < val.length; i++) {
            //finche' non inserisce il valore
            while(current != null) {
                //se il valore e' maggiore della radice
                if(val[i] < current.getValue()) {
                    prev = current;
                    current = current.getSx();
                    flag = false;
                }
                //se il valore e' minore della radice
                else if(val[i] > current.getValue()) {
                    prev = current;
                    current = current.getDx();
                    flag = true;
                }
                //gli alberi binari di ricerca non accettano doppioni
                else {
                    System.out.println("Errore! Valore uguale!");
                    return;
                }
                //se sono in una nuova foglia di una radice < o > di val termino
                if(current == null) {
                    //se e' maggiore allora crea la foglia a destra
                    if(flag)
                        prev.setDx(new NodoAlbero(val[i]));
                    //altrimenti se e' minore allora e' la destra
                    else
                        prev.setSx(new NodoAlbero(val[i]));
                    break;
                }
            }
            //ha inserito un nuovo valore e passa al prossimo
        }
        
    }
    
    /* 
     * metodo che ritorna il valore massimo nell'albero
     */
    public char cercaMax() {
        char val = 0;
        NodoAlbero node = null;
        
        if(this.root == null)
            return 0;
        //inizia dalla radice
        node = this.root;
        //fiche' ci sono figli destri li scorre
        while(node.getDx() != null)
            node = node.getDx();
        //l'ultimo e' il valore maggiore
        val = node.getValue();
        
        return val;
    }
    
    /* 
     * metodo che ritorna il valore massimo nell'albero
     */
    public char cercaMin() {
        char val = 0;
        NodoAlbero node = null;
        
        if(this.root == null)
            return 0;
        //inizia dalla radice
        node = this.root;
        //fiche' ci sono figli destri li scorre
        while(node.getDx() != null)
            node = node.getSx();
        //l'ultimo e' il valore maggiore
        val = node.getValue();
        
        return val;
    }
    
}
