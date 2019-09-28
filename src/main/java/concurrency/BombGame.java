package concurrency;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.util.concurrent.atomic.AtomicBoolean;

class MyKey extends GlobalKeyAdapter {

    private AtomicBoolean signal = new AtomicBoolean();

    public MyKey() {
        super();
    }

    @Override
    public void keyPressed(GlobalKeyEvent event) {
        signal.set(true);
    }

    @Override
    public void keyReleased(GlobalKeyEvent event) {
        super.keyReleased(event);
    }

    public AtomicBoolean getSignal() {
        return signal;
    }
}


class Bomb extends Thread {

    private MyKey myKey;

    public Bomb(MyKey myKey) {
        this.myKey = myKey;
    }

    private AtomicBoolean active = new AtomicBoolean(false);

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                System.out.println(active.get());
                Thread.sleep(100);
                if (active.get())
                    active.set(false);
                else
                    active.set(true);
            } catch (InterruptedException e) {
                break;
            }

            if (myKey.getSignal().get()) break;
        }

        if (active.get()) System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAAAAAANGGGG");
        else System.out.println("BOMB DEACTIVATED!!!");
        System.exit(0);

    }
}

public class BombGame {
    public static void main(String[] args) throws InterruptedException {

        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);// Use false here to switch to hook instead of raw input
        MyKey myKey = new MyKey();
        keyboardHook.addKeyListener(myKey);
        Bomb bomb = new Bomb(myKey);
        bomb.start();
    }
}
