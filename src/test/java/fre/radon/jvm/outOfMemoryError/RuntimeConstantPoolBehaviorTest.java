package fre.radon.jvm.outOfMemoryError;

/**
 * @author Radon Freedom
 */

public class RuntimeConstantPoolBehaviorTest {

    public static void main(String[] args) {

        String str1 = new StringBuilder("Radon ").append("Freedom").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }
}
