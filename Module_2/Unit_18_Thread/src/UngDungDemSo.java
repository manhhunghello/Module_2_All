public class UngDungDemSo {
    public static class Count implements Runnable {
        private Thread myThread;


        public Count() {

            //Phương thức khởi tạo không tham số tạo một luồng mới
            // và khởi động nó bằng cách gọi start() trong phương thức khởi tạo.
            // Nó in ra thông báo "My thread created" và thông tin về luồng.
            myThread = new Thread(this, "Chủ đề có thể chạy được của tôi");
            System.out.println("Chủ đề của tôi đã tạo" + myThread);
            myThread.start();
        }

        public Thread getMyThread() {  /////Phương thức getMyThread() trả về luồng myThread.//////
            return myThread;
        }

        public Count(Thread myThread) {
            this.myThread = myThread;
        }

        @Override
        public void run() {
           // Phương thức run() triển khai từ giao diện Runnable và được gọi khi luồng được khởi động
            try {
                for (int i = 0; i<= 10; i++) {
                    System.out.println("In so dem: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Chủ đề của tôi bị gián đoạn");
            }
            System.out.println("Chủ đề của tôi bị gián đoạn");
        }




            public static void main(String[] args) {

            Count count = new Count();

            try {

//          Trong một vòng lặp, kiểm tra xem luồng của count có còn sống hay không bằng cách gọi isAlive().
//          Nếu luồng còn sống, in ra thông báo "Chủ đề chính sẽ tồn tại cho đến khi chủ đề con được phát trực tiếp" và chờ 1,5 giây (Thread.sleep(1500)).
//          Nếu luồng count không còn sống, in ra thông báo "da xong".
                while (count.getMyThread().isAlive()) {
                    System.out.println("Chủ đề chính sẽ tồn tại cho đến khi chủ đề con được phát trực tiếp");
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                System.out.println("gian doan");
            }
            System.out.println("da xong");



            }

    }
}
