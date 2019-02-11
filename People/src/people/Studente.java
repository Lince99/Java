/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import java.util.Calendar;

/**
 *
 * @author s01118
 */
public class Studente extends Persona
{
    String scuola;
    String indirizzo;
    String classe;
    String matricola;
    int annoFreq;
    int media;
    int credito;
    
    
    
    //costruttori
    public Studente()
    {
        super();
        this.scuola = new String("");
        this.indirizzo = new String("");
        this.classe = new String("");
        this.matricola = new String("");
        this.annoFreq = Calendar.getInstance().get(Calendar.YEAR);
        this.media = -1;
        this.credito = -1;
    }
    
    public Studente(String nome, String cognome, int sesso, 
                    String scuola, String indir, String classe, int anno)
    {
        super(nome, cognome, sesso);
        this.scuola = scuola;
        this.indirizzo = indir;
        this.classe = classe;
        this.annoFreq = anno;
        this.matricola = new String("");
        this.media = -1;
        this.credito = -1;
    }
    
    //metodi get
    public String getScuola()
    {
        return this.scuola;
    }
    
    public String getIndirizzo()
    {
        return this.indirizzo;
    }
    public String getClasse()
    {
        return this.classe;
    }
    
    public int getannoFreq()
    {
        return this.annoFreq;
    }
    
    public String getMatricola()
    {
        return this.matricola;
    }
    
    public int getMedia()
    {
        return this.media;
    }
    
    public int getCredito()
    {
        return this.credito;
    }
    //metodi set
    
}
