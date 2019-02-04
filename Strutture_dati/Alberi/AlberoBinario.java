/*
 * Basso Nicola
 * 4^AI
 * 04/02/2019
 */
/*
 * creazione di una struttura dati ad albero binario
 */

package Alberi;

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

}
