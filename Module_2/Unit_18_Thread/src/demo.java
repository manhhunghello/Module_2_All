public class demo {
        public static void main(String[] args) {
            int countDown = 10;

            while (true) {
                System.out.println(countDown);
                countDown--;

                if (countDown < 0) {
                    break;
                }

                try {
                    Thread.sleep(1000); // Dừng 1 giây
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Kết thúc đếm ngược");
        }


}
