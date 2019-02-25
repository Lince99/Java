/*
 * Basso Nicola
 * 4^AI
 * 04/02/2019
 */
/*
 * utilizzo della classe AlberoBinario con le varie stampe di prova
 * con i valori che devono essere univoci
 */

package Alberi;

public class Albero {

    public static void main(String args[]) {
        AlberoBinario tree = new AlberoBinario();
        AlberoBinario tree2 = tree;
        char find = 'K';
        
        tree.addLeafSx('A', 'A');
        stampaDebug(tree);
        tree.addLeafSx('A', 'B');
        stampaDebug(tree);
        tree.addLeafDx('B', 'C');
        stampaDebug(tree);
        tree.addLeafDx('A', 'D');
        stampaDebug(tree);
        tree.addLeafSx('D', 'E');
        stampaDebug(tree);
        tree.addLeafDx('D', 'F');
        stampaDebug(tree);
        tree.addLeafSx('F', 'G');
        stampaDebug(tree);
        
        
        
        print_all(tree);
        
        System.out.println("Nodo "+find+" trovato "+
                           tree.cercaConta(tree.getRoot(), find)+" volte.");
        
        tree2.addLeafSx('G', 'H');
        System.out.println("\n\nSecondo albero:");
        print_all(tree);
        if(tree.stessaStruttura(tree.getRoot(), tree2.getRoot()))
            System.out.println("I due alberi hanno la stessa struttura");
        else
            System.out.println("I due alberi NON hanno la stessa struttura");
        
        
        System.out.println("\n\nAlbero binario di ricerca BST:");
        AlberoBinario ordered = new AlberoBinario();
        char[] values = {'A', 'B', 'D', 'C', 'J', 'K', 'Z', 'F',};
        ordered.fillOrdinato(values);
        print_all(ordered);
        System.out.println("Minimo: "+ordered.cercaMin()+
                           "\tMassimo = "+ordered.cercaMin());
        
    }
    
    private static void stampaDebug(AlberoBinario tree) {
        
        tree.visita_InOrder(tree.getRoot());
        System.out.println("\n- - - - - - -");
        
    }
    
    private static void print_all(AlberoBinario tree) {
        
        System.out.println("Pre-Order:");
        tree.visita_PreOrder(tree.getRoot());
        System.out.print("\n");
        System.out.println("In-Order:");
        tree.visita_InOrder(tree.getRoot());
        System.out.print("\n");
        System.out.println("Post-Order:");
        tree.visita_PostOrder(tree.getRoot());
        System.out.print("\n\n");
        
    }
}
