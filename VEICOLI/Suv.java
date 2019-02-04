package VEICOLI;


/**
 * Class Suv
 */
public class Suv extends Autoveicolo {

    //
    // Fields
    //
    /**

     * numero di ruote motrici
     * (accetta solo numeri pari)     */

    private int route_motrici;
    
    //
    // Constructors
    //
    public Suv () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of route_motrici
     * numero di ruote motrici
     * (accetta solo numeri pari)
     * @param newVar the new value of route_motrici
     */
    private void setRoute_motrici (int newVar) {
        route_motrici = newVar;
    }

    /**
     * Get the value of route_motrici
     * numero di ruote motrici
     * (accetta solo numeri pari)
     * @return the value of route_motrici
     */
    private int getRoute_motrici () {
        return route_motrici;
    }

    //
    // Other methods
    //

    /**
     * cambia la tipologia di trazionne (2 ruote = 1 trazione)
     * @param        traz 0 = posteriore
     * 1 = anteriore
     * 2 = 4x4
     * 3 = integrale
     */
    public void cambia_trazione(int traz)
    {
        if(traz < (int)this.route_motrici/2)
            trazione = traz;
    }


}
