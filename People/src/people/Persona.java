/*
* Basso Nicola
* 4^AI
* 19/09/2018
* last update: 20/09/2018
*/
/*
* Classe composta dai dati personali di una persona
*/
package people;

/**
 *
 * @author s01118
 */
public class Persona
{
    /*
    * attributi definiti secondo il NIST 
    * (National Institute of Standards and Technology).
    * Sono usati soltanto quelli necessari.
    */
    String nome;
    String cognome;
    int sesso; //0= femmina, 1= maschio, -1= sconosciuto/non specificato
    String residenza;
    String nin; //national identification number, dipende dai vari stati
    String data_nascita;
    String telefono;
    
    //costruttori
    public Persona()
    {
        this.nome = new String("");
        this.cognome = new String("");
        this.sesso = 2;
        this.residenza = new String("");
        this.nin = new String("");
        this.data_nascita = new String("");
        this.telefono = new String("");
    }
    
    public Persona(String n, String r)
    {
        this.nome = n;
        this.cognome = new String("");
        this.sesso = -1;
        this.residenza = r;
        this.nin = new String("");
        this.data_nascita = new String("");
        this.telefono = new String("");
    }
    
    public Persona(String n, String c, int s)
    {
        this.nome = n;
        this.cognome = c;
        this.sesso = s;
        this.residenza = new String("");
        this.nin = new String("");
        this.data_nascita = new String("");
        this.telefono = new String("");
    }
    
    public Persona(String n, String c, int s, String d)
    {
        this.nome = n;
        this.cognome = c;
        this.sesso = s;
        this.residenza = d;
        this.nin = new String("");
        this.data_nascita = new String("");
        this.telefono = new String("");
    }
    
    //metodi get
    public String getNome()
    {
        return this.nome;
    }
    public String getCognome()
    {
        return this.cognome;
    }
    public int getSesso()
    {
        return this.sesso;
    }
    public String getResidenza()
    {
        return this.residenza;
    }
    public String getNin()
    {
        return this.nin;
    }
    public String getData_nascita()
    {
        return this.data_nascita;
    }
    public String getTelefono()
    {
        return this.telefono;
    }
    
    //metodi set con gestione degli errori
    public void setNome(String n)
    {
        try
        {
            if(!n.isEmpty())
                this.nome = n;
        } catch (Exception e) {
            System.out.println("Nome non valido!\n"+e);
        }
    }
    public void setCognome(String c)
    {
        try
        {
            if(!c.isEmpty())
                this.cognome = c;
        } catch (Exception e) {
            System.out.println("Cognome non valido!\n"+e);
        }
    }

    public void setSesso(int s)
    {
        try
        {
            if (s >= -1 || s <= 1)
                this.sesso = s;
            else
                this.sesso = -1;
        } catch (Exception e) {
            System.out.println("Sesso non valido!\n"+e);
        }
    }
    
    public void setResidenza(String r)
    {
        try
        {
            if(!r.isEmpty())
                this.residenza = r;
        } catch (Exception e) {
            System.out.println("Residenza non valida!\n"+e);
        }
    }
    
    public void setNin(String n)
    {
        try
        {
            if(!n.isEmpty())
                this.nin = n;
        } catch (Exception e) {
            System.out.println("Codice identificativo non valido!\n"+e);
        }
    }
    
    public void setData_nascita(String d)
    {
        try
        {
            if(!d.isEmpty())
                this.data_nascita = d;
        } catch (Exception e) {
            System.out.println("Data nascita non valida!\n"+e);
        }
    }
    
    public void setTelefono(String t)
    {
        try
        {
            if(!t.isEmpty())
                this.telefono = t;
        } catch (Exception e) {
            System.out.println("Telefono non valido!\n"+e);
        }
    }
}
