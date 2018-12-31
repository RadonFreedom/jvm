package fre.radon.jvm.runtime;

import org.junit.Test;

/**
 *
 * @author Radon Freedom
 */

public class InvokeSuperStaticTest {


    @Test
    public void testInvokeSuperStaticMethod(){

        Sub.staticMethod();
    }
}


class Super{

    static {
        System.out.println("Super init!");
    }

    static void staticMethod(){
        System.out.println("Super.staticMethod");
    }
}

class Sub extends Super{

    static {

        System.out.println("Sub init!");
    }
}