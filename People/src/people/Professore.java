/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author s01118
 */
public class Professore extends Persona
{
    String ruolo;
    int stipendio;
    String corsiAffidati;
    
    //costruttori
    public Professore ()
    {
        super();
        this.ruolo = new String("");
        this.stipendio = -1;
        this.corsiAffidati = new String("");
    }
    
    public Professore (String nome, String indirizzo, String ruolo)
    {
        super(nome, indirizzo);
        this.ruolo = ruolo;
        this.stipendio = -1;
        this.corsiAffidati = new String("");
    }
    
    //metodi get
    public String getRuolo()
    {
        return this.ruolo;
    }
    
    public int getStipendio()
    {
        return this.stipendio;
    }
    
    public String getCorsiAffidati()
    {
        return this.corsiAffidati;
    }
    
    //metodi set
    public void setStipendio(int stipendio)
    {
        try
        {
            if(stipendio > 0)
                this.stipendio = stipendio;
            else
                System.out.println("Stipendio errato!\n Deve essere > di 0");
        } catch(Exception e) {
            System.out.println("Stipendio errato!\n Cifra non identificata");
        }
    }
    
    public void aumentaStipendio(int aumento)
    {
        try
        {
            //lo stipendio non puo' andare in negativo (-1 usato per controllo)
            if((this.stipendio + aumento) < 0)
            {
                System.out.println("Aumento di stipendio negativo!");
                this.stipendio = -1;
            }
            else
                this.stipendio += aumento;
        } catch(Exception e) {
            System.out.println("Aumento di stipendio errato!");
        }
    }
    
    public void aggiungiCorso(String corso)
    {
    }
    
    public void visualizza()
    {
    }
}
