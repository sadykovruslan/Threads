public class VolatilEx {
    private static volatile int myInt =0;
    public static void main(String[] args) {
       new changeListener().start();
       new changeMaker().start();
    }

    static class changeListener extends Thread {
        public void run(){
            int localValue = myInt;
            while (localValue < 5) {
                if(localValue !=myInt) {
                    System.out.println("Got change for myInt " + myInt);
                    localValue = myInt;
                }
            }
        }
    }

    static class changeMaker extends Thread {
        public void run(){
                int localValue = myInt;
                while (myInt < 5) {
                    System.out.println("Incrementing myInt " + (localValue +1));
                    myInt = ++localValue;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

