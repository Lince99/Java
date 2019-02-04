package VEICOLI;


/**
 * Class TrasportoEccezionale
 */
public class TrasportoEccezionale extends Autoarticolato {

    //
    // Fields
    //

    /**
     * lunghezza attuale del mezzo
     */
    private float lunghezza;    /**

     * orario da a quando puo' viaggiare il veicolo
     * Esempio: "23:00 - 04:00" dalle 11 di sera fino alle 4 di mattina     */

    private String orario_permesso;
    
    //
    // Constructors
    //
    public TrasportoEccezionale () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of lunghezza
     * lunghezza attuale del mezzo
     * @param newVar the new value of lunghezza
     */
    private void setLunghezza (float newVar) {
        lunghezza = newVar;
    }

    /**
     * Get the value of lunghezza
     * lunghezza attuale del mezzo
     * @return the value of lunghezza
     */
    private float getLunghezza () {
        return lunghezza;
    }

    /**
     * Set the value of orario_permesso
     * orario da a quando puo' viaggiare il veicolo
     * Esempio: "23:00 - 04:00" dalle 11 di sera fino alle 4 di mattina
     * @param newVar the new value of orario_permesso
     */
    private void setOrario_permesso (String newVar) {
        orario_permesso = newVar;
    }

    /**
     * Get the value of orario_permesso
     * orario da a quando puo' viaggiare il veicolo
     * Esempio: "23:00 - 04:00" dalle 11 di sera fino alle 4 di mattina
     * @return the value of orario_permesso
     */
    private String getOrario_permesso () {
        return orario_permesso;
    }

    //
    // Other methods
    //

}
