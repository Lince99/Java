package VEICOLI;


/**
 * Class Motoveicolo
 */
abstract public class Motoveicolo extends Veicolo {

    //
    // Fields
    //

    /**
     * se sono presenti le protezioni laterali anti-striscio
     */
    protected boolean protezioni;    /**

     * 0 = non ci sono
     * 1 = ci sono
     * per considerare i vari ibridi (Ciao)     */

    protected boolean pedali;
    
    //
    // Constructors
    //
    public Motoveicolo () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of protezioni
     * se sono presenti le protezioni laterali anti-striscio
     * @param newVar the new value of protezioni
     */
    protected void setProtezioni (boolean newVar) {
        protezioni = newVar;
    }

    /**
     * Get the value of protezioni
     * se sono presenti le protezioni laterali anti-striscio
     * @return the value of protezioni
     */
    protected boolean getProtezioni () {
        return protezioni;
    }

    /**
     * Set the value of pedali
     * 0 = non ci sono
     * 1 = ci sono
     * per considerare i vari ibridi (Ciao)
     * @param newVar the new value of pedali
     */
    protected void setPedali (boolean newVar) {
        pedali = newVar;
    }

    /**
     * Get the value of pedali
     * 0 = non ci sono
     * 1 = ci sono
     * per considerare i vari ibridi (Ciao)
     * @return the value of pedali
     */
    protected boolean getPedali () {
        return pedali;
    }

    //
    // Other methods
    //

}
