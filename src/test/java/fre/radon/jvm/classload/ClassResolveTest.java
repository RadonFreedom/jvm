package fre.radon.jvm.classload;

/**
 * 静态引用出现歧义的状况
 *
 * @author Radon Freedom
 */

public class ClassResolveTest {

    public static void main(String[] args) {

//        无法通过编译：son有两个同名的静态引用
//        System.out.println(Son.a);
    }
}

class Father {
    public static int a;
}

interface F {
    int a = 0;
}

class Son extends Father implements F {


}




