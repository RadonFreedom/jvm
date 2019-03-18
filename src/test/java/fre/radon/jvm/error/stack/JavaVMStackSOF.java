package fre.radon.jvm.error.stack;

import java.math.BigDecimal;

/**
 * VM Args: -Xss64k
 * 设置了单个线程的最大栈内存
 * 线程的虚拟机栈的栈帧数量超过限制抛出SOF。
 *
 * @author Radon Freedom
 */

public class JavaVMStackSOF {

    private int stackLength = 1;

    public int getStackLength() {
        return stackLength;
    }

    public void stackLeak() {

        BigDecimal bigDecimal = BigDecimal.valueOf(100);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(100);
        BigDecimal bigDecimal3 = BigDecimal.valueOf(100);

        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        JavaVMStackSOF stackSOF = new JavaVMStackSOF();

        try {
            stackSOF.stackLeak();
        } catch (Throwable t) {
            System.out.println("stack length: " + stackSOF.getStackLength());
            System.out.println(t.getClass().getName());
        }
    }
}
