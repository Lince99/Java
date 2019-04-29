public class Consumer implements Runnable {
    Item item;
    private int times;

    public Consumer(Item i, int times) {
        this.item = i;
        this.times = times*100;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            this.item.get();
            try {
                Thread.sleep(times);
            } catch(InterruptedException e) {
                System.out.println("Interrupted sleep!");
            }
        }
    }
 }

