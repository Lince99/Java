/*
 * Basso Nicola
 * 4^AI
 * 04/02/2019
 */
/*
 * nodo singolo di un albero binario
 */

package Alberi;

public class NodoAlbero {
    private char value;
    private NodoAlbero sx;
    private NodoAlbero dx;

    public NodoAlbero() {
        this.value = 0;
        sx = null;
        dx = null;
    }
    public NodoAlbero(char c) {
        this.value = c;
        sx = null;
        dx = null;
    }

    public void setValue(char val) {
        this.value = val;
    }
    public char getValue() {
        return this.value;
    }
    public void setSx(NodoAlbero node) {
        this.sx = node;
    }
    public NodoAlbero getSx() {
        return this.sx;
    }
    public void setDx(NodoAlbero node) {
        this.dx = node;
    }
    public NodoAlbero getDx() {
        return this.dx;
    }

}
