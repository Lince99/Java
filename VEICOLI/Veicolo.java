package VEICOLI;


/**
 * Class Veicolo
 * Classe che verra' ereditata dalle sottoclassi divise per categoria
 */
abstract public class Veicolo {

    //
    // Fields
    //

    protected String marca;
    protected int passeggeri;
    /**
     * numero di ruote del veicolo
     */
    protected int ruote;
    protected float peso;
    /**
     * tipologia di motore usato
     */
    protected String motore;
    protected int cavalli;
    protected int cilindrata;
    protected String targa;
    /**
     * tipo di trazione inserito da metodi delle classi figlie
     */
    protected int trazione;
    protected float serbatoio;
    /**
     * massimo carburante disponibile per il mezzo
     */
    protected float max_serbatoio;
    /**
     * velocita attuale del veicolo
     */
    protected float velocita;
    
    //
    // Constructors
    //
    public Veicolo () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of marca
     * @param newVar the new value of marca
     */
    protected void setMarca (String newVar) {
        marca = newVar;
    }

    /**
     * Get the value of marca
     * @return the value of marca
     */
    protected String getMarca () {
        return marca;
    }

    /**
     * Set the value of passeggeri
     * @param newVar the new value of passeggeri
     */
    protected void setPasseggeri (int newVar) {
        passeggeri = newVar;
    }

    /**
     * Get the value of passeggeri
     * @return the value of passeggeri
     */
    protected int getPasseggeri () {
        return passeggeri;
    }

    /**
     * Set the value of ruote
     * numero di ruote del veicolo
     * @param newVar the new value of ruote
     */
    protected void setRuote (int newVar) {
        ruote = newVar;
    }

    /**
     * Get the value of ruote
     * numero di ruote del veicolo
     * @return the value of ruote
     */
    protected int getRuote () {
        return ruote;
    }

    /**
     * Set the value of peso
     * @param newVar the new value of peso
     */
    protected void setPeso (float newVar) {
        peso = newVar;
    }

    /**
     * Get the value of peso
     * @return the value of peso
     */
    protected float getPeso () {
        return peso;
    }

    /**
     * Set the value of motore
     * tipologia di motore usato
     * @param newVar the new value of motore
     */
    protected void setMotore (String newVar) {
        motore = newVar;
    }

    /**
     * Get the value of motore
     * tipologia di motore usato
     * @return the value of motore
     */
    protected String getMotore () {
        return motore;
    }

    /**
     * Set the value of cavalli
     * @param newVar the new value of cavalli
     */
    protected void setCavalli (int newVar) {
        cavalli = newVar;
    }

    /**
     * Get the value of cavalli
     * @return the value of cavalli
     */
    protected int getCavalli () {
        return cavalli;
    }

    /**
     * Set the value of cilindrata
     * @param newVar the new value of cilindrata
     */
    protected void setCilindrata (int newVar) {
        cilindrata = newVar;
    }

    /**
     * Get the value of cilindrata
     * @return the value of cilindrata
     */
    protected int getCilindrata () {
        return cilindrata;
    }

    /**
     * Set the value of targa
     * @param newVar the new value of targa
     */
    protected void setTarga (String newVar) {
        targa = newVar;
    }

    /**
     * Get the value of targa
     * @return the value of targa
     */
    protected String getTarga () {
        return targa;
    }

    /**
     * Set the value of trazione
     * tipo di trazione inserito da metodi delle classi figlie
     * @param newVar the new value of trazione
     */
    protected void setTrazione (int newVar) {
        trazione = newVar;
    }

    /**
     * Get the value of trazione
     * tipo di trazione inserito da metodi delle classi figlie
     * @return the value of trazione
     */
    protected int getTrazione () {
        return trazione;
    }

    /**
     * Set the value of serbatoio
     * @param newVar the new value of serbatoio
     */
    protected void setSerbatoio (float newVar) {
        serbatoio = newVar;
    }

    /**
     * Get the value of serbatoio
     * @return the value of serbatoio
     */
    protected float getSerbatoio () {
        return serbatoio;
    }

    /**
     * Set the value of max_serbatoio
     * massimo carburante disponibile per il mezzo
     * @param newVar the new value of max_serbatoio
     */
    protected void setMax_serbatoio (float newVar) {
        max_serbatoio = newVar;
    }

    /**
     * Get the value of max_serbatoio
     * massimo carburante disponibile per il mezzo
     * @return the value of max_serbatoio
     */
    protected float getMax_serbatoio () {
        return max_serbatoio;
    }

    /**
     * Set the value of velocita
     * velocita attuale del veicolo
     * @param newVar the new value of velocita
     */
    protected void setVelocita (float newVar) {
        velocita = newVar;
    }

    /**
     * Get the value of velocita
     * velocita attuale del veicolo
     * @return the value of velocita
     */
    protected float getVelocita () {
        return velocita;
    }

    //
    // Other methods
    //

    /**
     * @param        speed variazione di velocita' sia positiva che negativa
     * (retromarcia)
     */
    public void muovi(float speed)
    {
        this.velocita = speed;
    }


    /**
     * aggiunge carburante al mezzo fino al max_serbatoio
     * @param        carburante quantita' di carburante immesso nel serbatoio
     */
    public void rifornisci(float carburante)
    {
        if((this.serbatoio + carburante) > this.max_serbatoio)
            this.serbatoio = this.max_serbatoio;
        else
            this.serbatoio += carburante;
    }


}
