package VEICOLI;


/**
 * Class Motocicletta
 */
public class Motocicletta extends Motoveicolo {

    //
    // Fields
    //
    /**

     * true= presenta una carenatura, aumento peso
     * false= non presente o tolta dal meccanico     */

    private boolean carenatura;    /**

     * true = parcheggiata
     * false = ritratto
     * Stato del cavalletto della moto     */

    private boolean cavalletto;
    
    //
    // Constructors
    //
    public Motocicletta () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of carenatura
     * true= presenta una carenatura, aumento peso
     * false= non presente o tolta dal meccanico
     * @param newVar the new value of carenatura
     */
    private void setCarenatura (boolean newVar) {
        carenatura = newVar;
    }

    /**
     * Get the value of carenatura
     * true= presenta una carenatura, aumento peso
     * false= non presente o tolta dal meccanico
     * @return the value of carenatura
     */
    private boolean getCarenatura () {
        return carenatura;
    }

    /**
     * Set the value of cavalletto
     * true = parcheggiata
     * false = ritratto
     * Stato del cavalletto della moto
     * @param newVar the new value of cavalletto
     */
    private void setCavalletto (boolean newVar) {
        cavalletto = newVar;
    }

    /**
     * Get the value of cavalletto
     * true = parcheggiata
     * false = ritratto
     * Stato del cavalletto della moto
     * @return the value of cavalletto
     */
    private boolean getCavalletto () {
        return cavalletto;
    }

    //
    // Other methods
    //

}
