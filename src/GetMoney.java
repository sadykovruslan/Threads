public class GetMoney {
    public static void main(String[] args) {
        ATM vakif = new ATM(100);
        User user1 = new User("Gosha");
        User user2 = new User("Sasha");
        User user3 = new User("Dasha");

        vakif.info();
        Thread t1 = new Thread((Runnable) () -> vakif.getSincMoney(user1, 50));
        Thread t2 = new Thread((Runnable) () -> vakif.getSincMoney(user2, 50));
        Thread t3 = new Thread((Runnable) () -> vakif.getSincMoney(user3, 50));


//        Thread t1 = new Thread((Runnable) () -> vakif.getMoney(user1, 50));
//        Thread t2 = new Thread((Runnable) () -> vakif.getMoney(user2, 50));
//        Thread t3 = new Thread((Runnable) () -> vakif.getMoney(user3, 50));

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vakif.info();

    }
}
