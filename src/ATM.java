public class ATM {
    private int money;

    public ATM(int money) {
        this.money = money;
    }

    public void getMoney(User user, int amount){
        if(money >= amount) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println("to " + user.getName() + ": " + amount);
        }
        else {
            System.out.println("to " + user.getName() + " not enough money");
        }
    }

    public synchronized void getSincMoney(User user, int amount){
        if(money >= amount) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println("to " + user.getName() + ": " + amount);
        }
        else {
            System.out.println("to " + user.getName() + " not enough money");
        }
    }

    public void info(){
        System.out.println("In ATM: " + money);
    }
}
