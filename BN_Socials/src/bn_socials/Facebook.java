/*
 * Basso Nicola
 * 4^AI
 * 22/10/2018
 */
/*
 * Classe specializzata solamente nel famoso social network
 */
package bn_socials;

/**
 *
 * @author s01118 aka Basso Nicola
 */
public final class Facebook extends SocialNetwork {
    
    //attributes
    private String[] storia;
    private int nAmici;
    
    
    
    //constructors
    public Facebook() {
        super();
        this.storia = new String[0];
        this.nAmici = 0;
    }
    /**
     * 
     * @param nome nome dell'account inserito da utente
     * @param password password scelta sempre dall'utente
     */
    public Facebook(String nome, String password) {
        super(nome, password);
        this.storia = new String[0];
        this.nAmici = 0;
    }
    
    
    
    //gets & sets
    /**
     * 
     * @return ritorna tutte le storie scritte dall'utente nel suo account FB
     */
    protected String[] getStoria() {
        return this.storia;
    }
    /**
     * 
     * @param max dimensione massima delle storie
     */
    protected void setStoria(int max) {
        this.storia = new String[max];
    }
    
    /**
     * 
     * @return ritorna il numero di amici dell'account corrente 
     */
    protected int getNAmici() {
        return this.nAmici;
    }
    /**
     * 
     * @param n imposta il numero degli amici dell'account 
     */
    protected void setNAmici(int n) {
        this.nAmici = n;
    }
    
    
    
    //methods
    /**
     * 
     * @return concatena tutte le informazioni dell'account del social FB
     */
    @Override
    protected String asString() {
        String all;
        
        all = super.asString() +
              "Numero di amici: "+getNAmici()+
              "Storie: "+printStoria();
        
        return all;
    }
    
    /**
     * 
     * @return concatena le storie salvate nell'account
     */
    protected String printStoria() {
        String print = new String("");
        int dim, i;
        
        dim = this.storia.length;
        for(i = 0; i < dim; i++) {
            print += "\n@ @ @ @ @ @ @ @\nStoria numero "+i+
                     "\n"+getStoria()[i];
        }
        print += "\n";
        
        return print;
    }
    
    /**
     * 
     * @param storia stringa da aggiungere alle storie
     * @param pos posizione nello storico delle storie
     */
    protected void addStoria(String storia, int pos) {
        this.storia[pos] = storia;
    }
    
}
