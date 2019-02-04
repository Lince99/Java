package VEICOLI;


/**
 * Class Quad
 */
public class Quad extends Motoveicolo {

    //
    // Fields
    //

    private boolean parafanghi;
    
    //
    // Constructors
    //
    public Quad () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of parafanghi
     * @param newVar the new value of parafanghi
     */
    private void setParafanghi (boolean newVar) {
        parafanghi = newVar;
    }

    /**
     * Get the value of parafanghi
     * @return the value of parafanghi
     */
    private boolean getParafanghi () {
        return parafanghi;
    }

    //
    // Other methods
    //

    /**
     * sovrascrittura della funzione della superclasse
     * per modificare anche la "sporcizia" nel quad
     * @param        speed incremento o diminuzione della velocita'
     */
    public void muovi(float speed)
    {
    }


}
