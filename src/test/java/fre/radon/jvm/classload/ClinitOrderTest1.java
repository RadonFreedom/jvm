package fre.radon.jvm.classload;

/**
 * 测试JVM的clinit方法。
 * 因为父类先于子类被类加载，所以父类的static代码块先于子类被执行。
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
