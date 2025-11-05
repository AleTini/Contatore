public class Main {
    public static void main(String[] args) {
        Contatore counter = new Contatore();
        Contatore_Synchronized syncCounter = new Contatore_Synchronized();

        // Create multiple th   reads to increment the counter
        Thread t1 = new Thread(() -> counter.increment());
        Thread t2 = new Thread(() -> counter.increment());
        Thread t3 = new Thread(() -> syncCounter.increment());
        Thread t4 = new Thread(() -> syncCounter.increment());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
        System.out.println("Final count: " + syncCounter.getCount());
    }
}
