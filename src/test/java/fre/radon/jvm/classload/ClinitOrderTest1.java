package fre.radon.jvm.classload;

/**
 * Parent's static block will be initialized before Sub's, since Parent will be
 * initialized before Sub during class-loading in the Method-Area.
 *
 * @author Radon Freedom
 */

public class ClinitOrderTest1 {

    public static void main(String[] args) {

        System.out.println(Sub.B);
    }
}

class Parent{

    public static int a = 1;

    static {
        a = 2;
    }
}

class Sub extends Parent {
    public static int B = a;
}
