/*
 * Basso Nicola
 * 4^AI
 * 22/10/2018
 */
/*
 * Classe utilizzata da quei social network con delle gallerie di immagini
 */
package bn_socials;

/**
 *
 * @author s01118 aka Basso Nicola
 */
public class Foto {
    
    //attributes
    private int larghezza;
    private int lunghezza;
    protected String descrizione;
    
    
    
    //constructors
    public Foto() {
        this.larghezza = 0;
        this.lunghezza = 0;
        this.descrizione = new String("Nessuna descrizione");
    }
    /**
     * 
     * @param larg larghezza dell'immagine in pixel
     * @param lung lunghezza dell'immagine in pixel
     */
    public Foto(int larg, int lung) {
        this.larghezza = 0;
        this.lunghezza = 0;
        this.descrizione = new String("Nessuna descrizione");
    }
    
    
    
    //gets & sets
    /**
     * 
     * @return ritorna la larghezza attuale dell'immagine in pixel
     */
    public int getLarghezza() {
        return this.larghezza;
    }
    /**
     * 
     * @param larg nuova dimensione dell'immagine in larghezza
     */
    protected void setLarghezza(int larg) {
        this.larghezza = larg;
    }
    
    /**
     * 
     * @return ritorna la lunghezza attuale dell'immagine in pixel
     */
    public int getLunghezza() {
        return this.lunghezza;
    }
    /**
     * 
     * @param lung nuova dimensione dell'immagine in lunghezza
     */
    protected void setLunghezza(int lung) {
        this.larghezza = lung;
    }
    
    /**
     * 
     * @return ritorna la descrizione dell'immagine inserita precedentemente 
     * dall'utente
     */
    public String getDescrizione() {
        return this.descrizione;
    }
    /**
     * 
     * @param newDescr nuova descrizione dell'immagine
     */
    public void setDescrizione(String newDescr) {
        this.descrizione = newDescr;
    }
    
    
    
    //methods
}
