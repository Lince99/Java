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

        tree.addLeafSx('A', 'A');
        tree.addLeafSx('A', 'B');
        tree.addLeafDx('B', 'C');
        tree.addLeafDx('A', 'D');
        tree.addLeafSx('D', 'E');
        tree.addLeafDx('D', 'F');
        tree.addLeafSx('F', 'G');

        print_all(tree);
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
