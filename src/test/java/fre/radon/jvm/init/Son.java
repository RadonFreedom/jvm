package fre.radon.jvm.init;

/**
 * 使用javap命令反编译 {@link Son} 的.class文件后可以发现，
 * "<"init">"函数中包含的内容以及执行先后顺序是：
 * 调用父类"<"init">"、{域赋值和语句块执行}、
 * 源码中的构造器方法中除了调用父类"<"init">"之外的初始化语意。 <br>
 * 其中{@link InitOrder 域赋值和语句块执行的顺序}由源码中的代码顺序决定。
 * @author Radon Freedom
 */

public class Son extends Father {

    private int intField = 0;

    {
        intField = 20;
    }

    public Son() {
        this.intField = 30;
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}
