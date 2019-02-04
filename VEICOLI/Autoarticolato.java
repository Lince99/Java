package VEICOLI;


/**
 * Class Autoarticolato
 */
abstract public class Autoarticolato extends Veicolo {

    //
    // Fields
    //

    /**
     * numero di rimorchi
     */
    protected int rimorchi;
    /**
     * peso caricato attualmente
     */
    protected double carico;
    /**
     * peso massimo del mezzo + quello del carico
     */
    protected double max_peso;
    /**
     * numero di ruote dotate di freni
     */
    protected int ruote_frenanti;
    /**
     * data di partenza
     */
    protected String partenza;
    /**
     * data richiesta della consegna
     */
    protected String scadenza;
    /**
     * numero di serbatoi presenti nel camion
     */
    protected int n_serbatoi;
    
    //
    // Constructors
    //
    public Autoarticolato () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of rimorchi
     * numero di rimorchi
     * @param newVar the new value of rimorchi
     */
    protected void setRimorchi (int newVar) {
        rimorchi = newVar;
    }

    /**
     * Get the value of rimorchi
     * numero di rimorchi
     * @return the value of rimorchi
     */
    protected int getRimorchi () {
        return rimorchi;
    }

    /**
     * Set the value of carico
     * peso caricato attualmente
     * @param newVar the new value of carico
     */
    protected void setCarico (double newVar) {
        carico = newVar;
    }

    /**
     * Get the value of carico
     * peso caricato attualmente
     * @return the value of carico
     */
    protected double getCarico () {
        return carico;
    }

    /**
     * Set the value of max_peso
     * peso massimo del mezzo + quello del carico
     * @param newVar the new value of max_peso
     */
    protected void setMax_peso (double newVar) {
        max_peso = newVar;
    }

    /**
     * Get the value of max_peso
     * peso massimo del mezzo + quello del carico
     * @return the value of max_peso
     */
    protected double getMax_peso () {
        return max_peso;
    }

    /**
     * Set the value of ruote_frenanti
     * numero di ruote dotate di freni
     * @param newVar the new value of ruote_frenanti
     */
    protected void setRuote_frenanti (int newVar) {
        ruote_frenanti = newVar;
    }

    /**
     * Get the value of ruote_frenanti
     * numero di ruote dotate di freni
     * @return the value of ruote_frenanti
     */
    protected int getRuote_frenanti () {
        return ruote_frenanti;
    }

    /**
     * Set the value of partenza
     * data di partenza
     * @param newVar the new value of partenza
     */
    protected void setPartenza (String newVar) {
        partenza = newVar;
    }

    /**
     * Get the value of partenza
     * data di partenza
     * @return the value of partenza
     */
    protected String getPartenza () {
        return partenza;
    }

    /**
     * Set the value of scadenza
     * data richiesta della consegna
     * @param newVar the new value of scadenza
     */
    protected void setScadenza (String newVar) {
        scadenza = newVar;
    }

    /**
     * Get the value of scadenza
     * data richiesta della consegna
     * @return the value of scadenza
     */
    protected String getScadenza () {
        return scadenza;
    }

    /**
     * Set the value of n_serbatoi
     * numero di serbatoi presenti nel camion
     * @param newVar the new value of n_serbatoi
     */
    protected void setN_serbatoi (int newVar) {
        n_serbatoi = newVar;
    }

    /**
     * Get the value of n_serbatoi
     * numero di serbatoi presenti nel camion
     * @return the value of n_serbatoi
     */
    protected int getN_serbatoi () {
        return n_serbatoi;
    }

    //
    // Other methods
    //

    /**
     * @param        ganci numero di ganci da sganciare dal tir
     */
    public void sgancia(int ganci)
    {
    }


    /**
     * @param        ganci numero di ganci da aggiungere al tir
     */
    public void aggiancia(int ganci)
    {
    }


}
