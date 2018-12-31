package fre.radon.jvm.classload;

/**
 * @author Radon Freedom
 */

public class SychronizedClinitTest {

    static {

        if (true) {
            System.out.println(Thread.currentThread().toString() + "init this class");
            while (true);
        }
    }

    public static void main(String[] args) {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                System.out.println(Thread.currentThread() + "run over");
            }
        };

        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }
}


