public class ExampleBase_1 {
    public static void main(String[] args) {
        ThreadExampleClass t1 = new ThreadExampleClass();
        Thread t2 = new Thread( new RunnableExample());
        System.out.println("Start");
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stop");
    }
}
