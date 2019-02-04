/*
 * Basso Nicola
 * 4^AI
 * 22/10/2018
 */
/*
 * Superclasse che contiene gli attributi e metodi 
 * in comune a tutte le classi figlie
 */
package bn_socials;

/**
 *
 * @author s01118 aka Basso Nicola
 */
public abstract class SocialNetwork implements InterfSocial {
    
    //attributes
    protected String nome;
    protected String telefono;
    protected String password;
    protected Foto galleria[];
    protected boolean sospeso;
    protected boolean disattivato;
    
    
    
    //constructors
    /**
     * costruttore di default con valori generali (nome e numero non reali)
     */
    public SocialNetwork() {
        this.nome = new String("John Doe");
        this.telefono = new String("+00 00000000000");
        this.password = null;
        this.galleria = new Foto[0];
        this.sospeso = false;
        this.disattivato = false;
    }
    /**
     * 
     * @param nome nome dell'account scelto dall'utente
     * @param pswd password inserita dall'utente
     */
    public SocialNetwork(String nome, String pswd) {
        this.nome = nome;
        this.telefono = new String("+00 00000000000");
        this.password = pswd;
        this.galleria = new Foto[0];
        this.sospeso = false;
        this.disattivato = false;
    }
    
    
    
    //gets & sets
    /**
     * 
     * @return ritorna il nome visibile da tutti gli altri account
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * 
     * @param name cambio del nome del soggetto 
     */
    protected void setNome(String name) {
        this.nome = name;
    }
    
    /**
     * 
     * @return ritorna il telefono/cellulare del soggetto 
     */
    public String getTelefono() {
        return this.telefono;
    }
    /**
     * 
     * @param tel nuovo telefono/cellulare del soggetto 
     */
    protected void setTelefono(String tel) {
        this.telefono = tel;
    }
    
    /**
     * 
     * @return ritorna l'intera array di foto 
     */
    protected Foto[] getGalleria() {
        return this.galleria;
    }
    /**
     * 
     * @param dim dimensione della galleria
     */
    protected void setGalleria(int dim) {
        this.galleria = new Foto[dim];
    }
    
    /**
     * 
     * @return ritorna se l'account e' sospeso o no per accertamenti 
     */
    protected boolean isSospeso() {
        return this.sospeso;
    }
    /**
     * 
     * @param sosp cambia lo stato dell'account da sospeso a attivo e viceversa 
     */
    protected void setSospeso(boolean sosp) {
        this.sospeso = sosp;
    }
    
    /**
     * 
     * @return ritorna se l'account e' stato sospeso o e' attivo
     */
    protected boolean isDisattivato() {
        return this.disattivato;
    }
    /**
     * 
     * @param disable disattiva l'account o lo riabilita
     */
    protected void setDisattivato(boolean disable) {
        this.disattivato = disable;
    }
    
    
    
    //methods
    /**
     * 
     * @return concatena tutte le informazioni dell'account del social 
     */
    protected String asString() {
        String all;
        
        //se l'account ha problemi non mostra le informazioni
        if(isSospeso() || isDisattivato()) {
            all = "Nessuna informazione disponibile!\n";
        }
        else {
            all = "Username: "+getNome()+"\n"+
                  "telefono: "+getTelefono()+"\n"+
                  "Galleria: "+printGalleria()+"\n"+
                  "Stato: "+printStato();
        }
        
        return all;
    }
    
    /**
     * 
     * @return concatena le informazioni di tutte le foto contenute in galleria
     */
    protected String printGalleria() {
        String print = new String("");
        int dim, i;
        
        dim = this.galleria.length;
        for(i = 0; i < dim; i++) {
            print += "\n- - - - - - - -\nFoto "+i+
                     "\nDimensione: "+getGalleria()[i].getLunghezza()+
                     " x "+getGalleria()[i].getLarghezza()+
                     "\nDescrizione: "+getGalleria()[i].getDescrizione()+"\n";
        }
        
        return print;
    }
    
    /**
     * 
     * @return descrive lo stato dell'account
     */
    protected String printStato() {
        String print = new String("");
        
        if(isSospeso()) {
            print += "L'account e' SOSPESO PER ACCERTAMENTI\n";
        }
        else if(isDisattivato()) {
            print += "L'account e' DISATTIVATO\n";
        }
        else {
            print += "L'account e' attivo\n";
        }
        
        return print;
    }
}
