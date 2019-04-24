import java.util.ArrayList;

public class Tree{

    private NodoAlbero root;

    public Tree() {
        this.root = null;
    }

    public NodoAlbero getRoot() {
        return this.root;
    }

    public void setRoot(NodoAlbero newroot) {
        this.root = newroot;
    }

    /*
     * funzione che data la visita in-order e level-order popola l'albero
     */
    NodoAlbero creaAlbero(NodoAlbero root, ArrayList in, ArrayList level,
                          int start, int end) {
        boolean found = false;
        int index = 0;
        Object data = 0;

        if(start > end)
            return null;
        if(start == end)
            return new NodoAlbero(in.get(start));

        for(int i = 0; i < level.size(); i++) {
            data = level.get(i);
            for(int j = start; j < end; j++) {
                if(data == in.get(j)) {
                    root = new NodoAlbero(data);
                    index = j;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }

        root.setSx(creaAlbero(root, in, level, start, index-1));
        root.setDx(creaAlbero(root, in, level, index+1, end));

        return root;
    }

    public void printPre(NodoAlbero root) {
        if(root == null)
            return;
        System.out.print(root.getValue()+" ");
        printIn(root.getSx());
        printIn(root.getDx());
    }

    public void printIn(NodoAlbero root) {
        if(root == null)
            return;
        printIn(root.getSx());
        System.out.print(root.getValue()+" ");
        printIn(root.getDx());
    }

    public void printPost(NodoAlbero root) {
        if(root == null)
            return;
        printIn(root.getSx());
        printIn(root.getDx());
        System.out.print(root.getValue()+" ");
    }
}
