public class RunnableDemo implements Runnable {
    private Thread t;
    private final String threadName;

    public RunnableDemo(String Name) {
        this.threadName = Name;
    }

    public void start () {
        System.out.println(" Bat dau chay" + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    @Override
    public void run() {
        System.out.println("Dang chay" + threadName);

        try {


            for (int i = 4; i > 0; i--) {
                System.out.println(" Thread : " + threadName + "," + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(" Thread" + threadName + " Bi dan doan.");

        }
        System.out.println(" Thoat ra");

    }

    public static void main(String[] args) {
        System.out.println("Main thread running... ");

        RunnableDemo runnableDemo1 = new RunnableDemo("Thread-1-HR-Database");
        runnableDemo1.start();

        RunnableDemo runnableDemo2 = new RunnableDemo("Thread-2-Send-Email");
        runnableDemo2.start();

        System.out.println("Main thread stopped!!! ");
    }

}
