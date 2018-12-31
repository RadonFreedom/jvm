package fre.radon.jvm.outOfMemoryError;

/**
 * VM args: -Xxs2M
 * @author Radon Freedom
 */

public class JavaVMStackOOM {

    private void noStop(){
        while (true);
    }

    public void stackLeakByThread(){

        while (true) {

            (new Thread(this::noStop)).start();
        }
    }
    public static void main(String[] args) {

        JavaVMStackOOM stackOOM = new JavaVMStackOOM();
        stackOOM.stackLeakByThread();
    }
}
