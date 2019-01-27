/*
 * Implementazione della struttura dati Pila
 */

import java.util.Vector;

public class Pila
{
    private Vector oggetti;

    public Pila()
    {
        oggetti = new Vector();
    }

    public Pila(int dim)
    {
        oggetti = new Vector(dim);
    }

    public void push(Object obj)
    {
        oggetti.addElemnt(obj);
    }

    public Object pop()
    {
        Object temp=NULL;

        int dim=0;
        dim=oggetti.size();


        if(dim>0)
        {
            temp=oggetti.elemntAt(dim-1);
            oggetti.removeElemntAt(dim-1);
        }

        return temp;
    }

    public void stampa(int pos)
    {
        oggetti.elemntAt(pos).stampa();
    }
}
