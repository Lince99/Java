/*
 * classe che descrive lo studente
 */



public class Studente
{
    private String nome;
    private String cognome;
    private int eta;

    public Studente()
    {
        this.nome = new String();
        this.cognome = new String();
        this.eta = 0;
    }

    public Studente(String nome, int eta)
    {
        this.nome = nome;
        this.cognome = new String();
        this.eta = eta;
    }

    public Studente(String nome, String cognome, int eta)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public void stampa()
    {
        System.out.println("Studente: "+this.eta+" anni.");
    }

    public void stampaAll()
    {
        System.out.println("Studente "+this.nome+" "+
                            this.cognome+": "+this.eta+" anni.");
    }
}
