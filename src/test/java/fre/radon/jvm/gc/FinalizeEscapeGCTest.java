package fre.radon.jvm.gc;

/**
 *
 * illustrates that JVM will call the to-be-GCed obj's overrided finalize() method
 * once and only once.
 *
 * @author Radon Freedom
 */

public class FinalizeEscapeGCTest {

    public static FinalizeEscapeGCTest SAVE_HOOK;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("FinalizeEscapeGCTest.finalize method executed!");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {

        new FinalizeEscapeGCTest();

        while (true) {
            SAVE_HOOK = null;
            System.out.println("start fre.radon.jvm.GC");
            System.gc();
            Thread.sleep(500);
            if (SAVE_HOOK != null)
                System.out.println("alive");
            else {
                System.out.println("dead");
                break;
            }
        }
    }
}
