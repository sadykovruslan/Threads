public class DeadLock1 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadThreadOne threadOne = new DeadThreadOne();
        DeadThreadTwo threadTwo = new DeadThreadTwo();

        threadOne.start();
        threadTwo.start();
    }

    public static class DeadThreadOne extends Thread {
        public void run(){
            synchronized (lock1) {
                System.out.println("DeadThreadOne is holding Lock 1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadRhreadOne is waiting Lock 2...");
                synchronized (lock2){
                    System.out.println("DeadThreadOne is holding Lock 1 and Lock 2...");
                }
            }
        }
    }

    public static class DeadThreadTwo extends Thread {
        public void run(){
            synchronized (lock2){
                System.out.println("DeadThreadTwo is holding Lock 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadRhreadTwo is waiting Lock 1...");
                synchronized (lock1){
                    System.out.println("DeadThreadTwo is holding Lock 1 and Lock 2...");
                }
            }
        }
    }
}
