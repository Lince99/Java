/*
 * Basso Nicola
 * 4^AI
 * 22/10/2018
 */
/*
 * Classe specializzata in un social network simile a Facebook
 */
package bn_socials;

/**
 *
 * @author s01118 aka Basso Nicola
 */
public class Instagram extends SocialNetwork  {
    
    //attributes
    private String storia[];
    private int followers;
    
    
    
    //constructors
    public Instagram() {
        super();
        this.storia = new String[0];
        this.followers = 0;
    }
    /**
     * 
     * @param nome nome dell'account inserito da utente
     * @param password password scelta sempre dall'utente
     */
    public Instagram(String nome, String password) {
        super(nome, password);
        this.storia = new String[0];
        this.followers = 0;
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
     * @return ritorna il numero di follower dell'account corrente 
     */
    protected int getFollowers() {
        return this.followers;
    }
    /**
     * 
     * @param f imposta il numero dei follower
     */
    protected void followers(int f) {
        this.followers = f;
    }
    
    
    
    //methods
    /**
     * 
     * @return concatena tutte le informazioni dell'account del social INSTA
     */
    @Override
    protected String asString() {
        String all;
        
        all = super.asString() +
              "Numero di follower: "+getFollowers()+
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
