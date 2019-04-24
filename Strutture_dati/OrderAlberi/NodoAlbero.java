public class NodoAlbero {

    private Object value;
    private NodoAlbero sx;
    private NodoAlbero dx;

    public NodoAlbero(Object val) {
        this.value = val;
        this.sx = null;
        this.dx = null;
    }

    public Object getValue() {
        return this.value;
    }

    public NodoAlbero getSx() {
        return this.sx;
    }

    public NodoAlbero getDx() {
        return this.dx;
    }

    public void setValue(Object val) {
        this.value = val;
    }

    public void setSx(NodoAlbero sx) {
        this.sx = sx;
    }

    public void setDx(NodoAlbero dx) {
        this.dx = dx;
    }
}
