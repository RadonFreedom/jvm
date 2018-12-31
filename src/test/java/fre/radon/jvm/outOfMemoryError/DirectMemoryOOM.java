package fre.radon.jvm.outOfMemoryError;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

import static fre.radon.jvm.Constants._1MB;

/**
 * VM options: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author Radon Freedom
 */

public class DirectMemoryOOM {

    public static void main(String[] args) throws IllegalAccessException {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
