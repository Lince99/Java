public class Main {

    public static void main(String[] args) {
        int times = 10;
        //shared memory
        Item itm = new Item();

        //consumer thread
        Consumer cs = new Consumer(itm, times);
        //producer thread
        Producer pd = new Producer(itm, times-1);
    }
}
