public class Contatore {
    private int count = 0;

    public synchronized void increment() {
        int i = 0;
        while(i < 5000){
            i++;
            count++;
            System.out.println("Sono al count: " + count);
        }
    }


    public int getCount() {
        return count;
    }
}

