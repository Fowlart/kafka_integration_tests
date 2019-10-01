package concurrency.concurent_modification;

public class Controller {

    public int handleSomthing(int input) {

        int rez = input;

        for (int i = 0; i < 1000; i++) {
            rez--;
            System.out.println(Thread.currentThread().getName()+": i= "+i+" rez= "+rez);
        }
        return rez;
    }

    public static void main(String[] args) {

        Controller controller = new Controller();

        Runnable user1 = () -> {
            int input = 1000;
            System.out.println(controller.handleSomthing(input));
        };

        Runnable user2 = () -> {
            int input = 2000;
            System.out.println(controller.handleSomthing(input));
        };

        new Thread(user1,"user1").start();
        new Thread(user2,"user2").start();

    }
}
