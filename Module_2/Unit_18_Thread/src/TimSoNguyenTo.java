//import java.util.ArrayList;
//import java.util.List;
//
//public class TimSoNguyenTo {
//
//    static class LazyPrimeFactorization implements Runnable {
//        private List<Integer> result = new ArrayList<>();
//
//        @Override
//        public void run() {
//            int number = 2;
//            int count = 0;
//            while (count < 20) {
//                if (isPrime(number)) {
//                    result.add(number);
//                    System.out.println("Tim thay so nguyen to: " + number);
//                    count++;
//                }
//                number++;
//            }
//        }
//
//        private boolean isPrime(long number) {
//            if (number < 2) {
//                return false;
//            }
//            for (int i = 2; i < number; i++) {
//                if (number % i == 0) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
//
//    static class OptimizedPrimeFactorization implements Runnable {
//        private List<Integer> primes;
//
//        public OptimizedPrimeFactorization() {
//            primes = new ArrayList<>();
//        }
//
//        @Override
//        public void run() {
//            int number = 2;
//            int count = 0;
//            while (count < 20) {
//                if (isPrime(number)) {
//                    primes.add(number);
//                    System.out.println("OptimizedPrimeFactorization: Found prime number - " + number);
//                    count++;
//                }
//                number++;
//            }
//        }
//
//        private boolean isPrime(int number) {
//            if (number < 2) {
//                return false;
//            }
//            int sqrt = (int) Math.sqrt(number);
//            for (int i = 2; i <= sqrt; i++) {
//                if (number % i == 0) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
//
//    public static void main(String[] args) {
//        LazyPrimeFactorization lpf = new LazyPrimeFactorization();
//        OptimizedPrimeFactorization opf = new OptimizedPrimeFactorization();
//        Thread thread1 = new Thread(lpf);
//        Thread thread2 = new Thread(opf);
//
//        thread1.start();
//
//        try {
//            thread1.join(); // Chờ thread1 chạy xong
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        thread2.start(); // Bắt đầu thread2 sau khi thread1 đã chạy xong
//    }
//}

import java.util.ArrayList;
import java.util.List;

public class TimSoNguyenTo {

    static class LazyPrimeFactorization implements Runnable {
        private List<Integer> result = new ArrayList<>();
        private final Object lock;

        public LazyPrimeFactorization(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            int number = 2;
            int count = 0;
            synchronized (lock) {
                try {
                    lock.wait(); // Đợi cho đến khi nhận được notify từ thread2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (count < 20) {
                if (isPrime(number)) {
                    synchronized (lock) {
                        result.add(number);
                        System.out.println("Tim thay so nguyen to: " + number);
                        count++;
                    }
                }
                number++;
            }
        }

        private boolean isPrime(long number) {
            if (number < 2) {
                return false;
            }
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static class OptimizedPrimeFactorization implements Runnable {
        private List<Integer> primes;
        private final Object lock;

        public OptimizedPrimeFactorization(Object lock) {
            this.lock = lock;
            primes = new ArrayList<>();
        }

        @Override
        public void run() {
            int number = 2;
            int count = 0;
            while (count < 20) {
                if (isPrime(number)) {
                    synchronized (lock) {
                        primes.add(number);
                        System.out.println("OptimizedPrimeFactorization: Found prime number - " + number);
                        count++;
                    }
                }
                number++;
            }
            synchronized (lock) {
                lock.notify(); // Gửi notify để thread1 tiếp tục thực thi
            }
        }

        private boolean isPrime(int number) {
            if (number < 2) {
                return false;
            }
            int sqrt = (int) Math.sqrt(number);
            for (int i = 2; i <= sqrt; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        LazyPrimeFactorization lpf = new LazyPrimeFactorization(lock);
        OptimizedPrimeFactorization opf = new OptimizedPrimeFactorization(lock);
        Thread thread1 = new Thread(lpf);
        Thread thread2 = new Thread(opf);

        thread1.start();
        thread2.start();
    }
}
