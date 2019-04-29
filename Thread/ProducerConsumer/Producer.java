public class Producer implements Runnable {
    Item item;
    private int times;

    public Producer(Item i, int times) {
        this.item = i;
        this.times = times*100;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            this.item.put(i);
            try {
                Thread.sleep(times);
            } catch(InterruptedException e) {
                System.out.println("Interrupted sleep!");
            }
        }
    }
}
