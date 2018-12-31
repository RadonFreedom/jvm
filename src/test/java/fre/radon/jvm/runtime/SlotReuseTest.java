package fre.radon.jvm.runtime;

import org.junit.Test;

import static fre.radon.jvm.Constants._1MB;

/**
 * @author Radon Freedom
 */

public class SlotReuseTest {

    @Test
    public void testSlotReuseAndGC() {

        {
            byte[] placeholder = new byte[64 * _1MB];
            placeholder = null;
        }
//        int a = 0;
        System.gc();
    }
}
