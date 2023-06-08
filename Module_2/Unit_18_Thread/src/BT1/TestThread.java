package BT1;

public class TestThread {
    public static class  OddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 10 ; i+=2) {
                System.out.println(" Cac so le la: " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }
    public static class EvenThread implements Runnable{

        @Override
        public void run() {
            for (int i = 2; i < 10 ; i+=2) {
                System.out.println(" cac so chan la: " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddThread());
        Thread evenThread = new Thread(new EvenThread());

        oddThread.start();
        evenThread.start();





    }
}
