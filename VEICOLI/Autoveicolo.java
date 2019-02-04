package VEICOLI;


/**
 * Class Autoveicolo
 */
abstract public class Autoveicolo extends Veicolo {

    //
    // Fields
    //

    /**
     * numero di airbag presenti
     */
    protected int airbag;
    /**
     * numero di porte presenti (incluso bagagliaio)
     */
    protected int porte;
    /**
     * se sono presenti optional si o no
     */
    protected boolean optional;
    /**
     * peso presente nel bagagliaio
     */
    protected float bagagliaio;
    /**
     * massimo caricabile nell'autoveicolo
     */
    protected float max_bagagliaio;
    
    //
    // Constructors
    //
    public Autoveicolo () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of airbag
     * numero di airbag presenti
     * @param newVar the new value of airbag
     */
    protected void setAirbag (int newVar) {
        airbag = newVar;
    }

    /**
     * Get the value of airbag
     * numero di airbag presenti
     * @return the value of airbag
     */
    protected int getAirbag () {
        return airbag;
    }

    /**
     * Set the value of porte
     * numero di porte presenti (incluso bagagliaio)
     * @param newVar the new value of porte
     */
    protected void setPorte (int newVar) {
        porte = newVar;
    }

    /**
     * Get the value of porte
     * numero di porte presenti (incluso bagagliaio)
     * @return the value of porte
     */
    protected int getPorte () {
        return porte;
    }

    /**
     * Set the value of optional
     * se sono presenti optional si o no
     * @param newVar the new value of optional
     */
    protected void setOptional (boolean newVar) {
        optional = newVar;
    }

    /**
     * Get the value of optional
     * se sono presenti optional si o no
     * @return the value of optional
     */
    protected boolean getOptional () {
        return optional;
    }

    /**
     * Set the value of bagagliaio
     * peso presente nel bagagliaio
     * @param newVar the new value of bagagliaio
     */
    protected void setBagagliaio (float newVar) {
        bagagliaio = newVar;
    }

    /**
     * Get the value of bagagliaio
     * peso presente nel bagagliaio
     * @return the value of bagagliaio
     */
    protected float getBagagliaio () {
        return bagagliaio;
    }

    /**
     * Set the value of max_bagagliaio
     * massimo caricabile nell'autoveicolo
     * @param newVar the new value of max_bagagliaio
     */
    protected void setMax_bagagliaio (float newVar) {
        max_bagagliaio = newVar;
    }

    /**
     * Get the value of max_bagagliaio
     * massimo caricabile nell'autoveicolo
     * @return the value of max_bagagliaio
     */
    protected float getMax_bagagliaio () {
        return max_bagagliaio;
    }

    //
    // Other methods
    //

    /**
     * ritorna il peso in eccesso se non e' riuscito a caricare tutto
     * @return       float
     * @param        peso peso caricato
     */
    public float carica(float peso)
    {
        float tmp;
        if((this.bagagliaio + peso) > this.max_bagagliaio) {
            tmp = this.bagagliaio;
            this.bagagliaio = max_bagagliaio;
            return this.max_bagagliaio - tmp + peso;
        }
        this.bagagliaio += peso;
        return 0;
    }


    /**
     * ritorna true se e' riuscito a scaricareù
     * ritorna false nel caso non ci sia nulla da scaricare
     * @return       Boolean
     * @param        peso
     */
    public Boolean scarica(float peso)
    {
        if(this.bagagliaio == 0)
            return false;
        if((this.bagagliaio - peso) < 0)
            this.bagagliaio = 0;
        this.bagagliaio -= peso;
        return true;
    }


}
