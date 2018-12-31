package fre.radon.jvm.init;

/**
 * 说明了不管是在 {@link fre.radon.jvm.classload.ClinitOrderTest2 clinit} 还是在 init 方法中，
 * 域赋值、语句块的顺序都是取决于源码顺序
 *
 * @author Radon Freedom
 * created at 2018.12.11 12:36
 */

public class InitOrder {

    private int i = 3;

    {
        i = 0;
    }
}
