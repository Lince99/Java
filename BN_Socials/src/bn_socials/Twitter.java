/*
 * Basso Nicola
 * 4^AI
 * 22/10/2018
 */
/*
 * Classe specializzata nel social network rivale di Instagram
 */
package bn_socials;

/**
 *
 * @author s01118 aka Basso Nicola
 */
public class Twitter extends SocialNetwork  {
    
    //attributes
    private int followers;
    
    
    
    //constructors
    public Twitter() {
        super();
        this.followers = 0;
    }
    /**
     * 
     * @param nome nome dell'account inserito da utente
     * @param password password scelta sempre dall'utente
     */
    public Twitter(String nome, String password) {
        super(nome, password);
        this.followers = 0;
    }
    
    
    
    //gets & sets
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
     * @return concatena tutte le informazioni dell'account del social TWITTER
     */
    @Override
    protected String asString() {
        String all;
        
        all = super.asString() +
              "Numero di amici: "+getFollowers()+"\n";
        
        return all;
    }
}
