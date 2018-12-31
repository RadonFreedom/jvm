package fre.radon.jvm.classload;

/**
 * 说明了 clinit 中的静态语句块和静态域赋值的执行顺序取决于源码顺序
 * ，这点和 {@link fre.radon.jvm.init.InitOrder init 方法的执行顺序}类似
 *
 * @author Radon Freedom
 */

public class ClinitOrderTest2 {

    static {

        i = 3;

//        非法前向引用：在语句块之后定义的域只能在语句块中赋值而不能引用
//        System.out.println(i);
    }

    static int i = 1;

    public static void main(String[] args) {

//        打印结果为 1 说明在本例中静态语句块先于静态域赋值被执行
        System.out.println(ClinitOrderTest2.i);
    }
}
