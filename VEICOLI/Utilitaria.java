package VEICOLI;


/**
 * Class Utilitaria
 */
public class Utilitaria extends Autoveicolo {

    //
    // Fields
    //
    /**

     * numero di appendiabiti presenti all'interno del veicolo
     *      */

    private int appendini;    /**

     * 0 = sedili verticali (normali)
     * 1 = sedili distesi in orizzontale per aumentare bagagliaio     */

    private boolean pos_sedili;
    
    //
    // Constructors
    //
    public Utilitaria () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of appendini
     * numero di appendiabiti presenti all'interno del veicolo
     * 
     * @param newVar the new value of appendini
     */
    private void setAppendini (int newVar) {
        appendini = newVar;
    }

    /**
     * Get the value of appendini
     * numero di appendiabiti presenti all'interno del veicolo
     * 
     * @return the value of appendini
     */
    private int getAppendini () {
        return appendini;
    }

    /**
     * Set the value of pos_sedili
     * 0 = sedili verticali (normali)
     * 1 = sedili distesi in orizzontale per aumentare bagagliaio
     * @param newVar the new value of pos_sedili
     */
    private void setPos_sedili (boolean newVar) {
        pos_sedili = newVar;
    }

    /**
     * Get the value of pos_sedili
     * 0 = sedili verticali (normali)
     * 1 = sedili distesi in orizzontale per aumentare bagagliaio
     * @return the value of pos_sedili
     */
    private boolean getPos_sedili () {
        return pos_sedili;
    }

    //
    // Other methods
    //

}
