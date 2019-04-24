import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private int size;

    public static void main(String[] args) {
        Tree elemTree = new Tree();
        NodoAlbero root = null;
        Scanner scan = new Scanner(System.in);
        int val = 0;

        //riceve in input la lista in-order
        ArrayList in_list = new ArrayList();
        System.out.println("Inserisci i valori della lista in-order (-1 termina):");
        do {
            val = scan.nextInt();
            if(val == -1)
                break;
            in_list.add(val);
        } while(val != -1);
        //riceve in input la lista level-order
        ArrayList level_list = new ArrayList();
        System.out.println("Inserisci i valori della lista in-order (-1 termina):");
        do {
            val = scan.nextInt();
            if(val == -1)
                break;
            level_list.add(val);
        } while(val != -1 && level_list.size() < in_list.size());
        System.out.println("In-Order: "+in_list);
        System.out.println("Level-Order: "+in_list);
        //popola l'albero seguendo le due liste
        root = elemTree.creaAlbero(root, in_list, level_list,
                            0, in_list.size()-1);
        //stampa le visite pre, in e post order
        System.out.println("Albero:");
        System.out.println("Pre-Order:");
        elemTree.printPre(root);
        System.out.println("In-Order:");
        elemTree.printIn(root);
        System.out.println("Post-Order:");
        elemTree.printPost(root);
    }
}
