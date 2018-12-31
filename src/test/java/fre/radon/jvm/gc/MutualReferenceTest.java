package fre.radon.jvm.gc;

/**
 * VM options: -XX:+PrintGCDetails. <br/>
 * illustrates that JVM use GC roots but not reference counter to decide whether to gc an obj.
 * @author Radon Freedom
 */

public class MutualReferenceTest {

    public Object instance;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[_1MB];

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public static void main(String[] args) {

        MutualReferenceTest o1, o2;
        o1 = new MutualReferenceTest();
        o2 = new MutualReferenceTest();

        o1.setInstance(o2);
        o2.setInstance(o1);

        o1 = null;
        o2 = null;

        System.gc();
    }
}














