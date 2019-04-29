import java.util.concurrent.Semaphore;

public class Item {

    int item;

    Semaphore semCon = new Semaphore(0);
    Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            //consumer lock
            semCon.acquire();
        } catch(InterruptedException e) {
            System.out.println("Interrupt Error!");
        }
        //consumer consume
        System.out.println("Consumer consumed item: " + this.item);
        //consumer release
        semProd.release();
    }

    void put(int item) {
        try {
            //producer lock
            semProd.acquire();
        } catch(InterruptedException e) {
            System.out.println("Interrupt Error!");
        }
        //producer produce
        this.item = item;
        System.out.println(" Producer produced item: " + this.item);
        //producer release
        semCon.release();
    }
}
