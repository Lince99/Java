package VEICOLI;


/**
 * Class CamionFrigo
 */
public class CamionFrigo extends Autoarticolato {

    //
    // Fields
    //

    /**
     * temperatura attuale del frigo
     */
    private float temperatura;
    /**
     * liquido usato dal frigo presente nell'apposito serbatoio
     */
    private float refrigerante;
    
    //
    // Constructors
    //
    public CamionFrigo () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of temperatura
     * temperatura attuale del frigo
     * @param newVar the new value of temperatura
     */
    private void setTemperatura (float newVar) {
        temperatura = newVar;
    }

    /**
     * Get the value of temperatura
     * temperatura attuale del frigo
     * @return the value of temperatura
     */
    private float getTemperatura () {
        return temperatura;
    }

    /**
     * Set the value of refrigerante
     * liquido usato dal frigo presente nell'apposito serbatoio
     * @param newVar the new value of refrigerante
     */
    private void setRefrigerante (float newVar) {
        refrigerante = newVar;
    }

    /**
     * Get the value of refrigerante
     * liquido usato dal frigo presente nell'apposito serbatoio
     * @return the value of refrigerante
     */
    private float getRefrigerante () {
        return refrigerante;
    }

    //
    // Other methods
    //

    /**
     * funzione che calcola la temperatura del carico
     * in base alla temperatura esterna
     * e al liquido refrigerante rimanente
     * @param        out temperatura esterna
     */
    private void calcola_temp(float out)
    {
        this.temperatura += out - this.refrigerante;
        this.refrigerante -= this.refrigerante / 10 / (this.temperatura + out);
    }


}
