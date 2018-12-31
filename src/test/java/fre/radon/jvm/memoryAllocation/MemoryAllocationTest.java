package fre.radon.jvm.memoryAllocation;

import org.junit.Test;

/**
 * @author Radon Freedom
 */
public class MemoryAllocationTest {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM options: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * <br/>
     * illustrate that most objects go into Eden + Survivor(from)
     */
    @Test
    public void newGenerationAllocation() {
//        minor gc might happen because other-objects+1MB might overflow Eden(8+1MB)
        byte[] alloc1 = new byte[_1MB];
    }

    /**
     * VM options: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * <br/>
     * illustrate that big objects go into OldGen
     */
    @Test
    public void bigObjectIntoOldGeneration() {

//        gc not happened when big objects go into OldGen
        byte[] alloc = new byte[4 * _1MB];
    }


    /**
     * VM options: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     * <br/>
     * illustrate that old objects go into OldGen
     */
    @Test
    public void testTenuringThreshold() {
        byte[] alloc1, alloc2;
        alloc1 = new byte[_1MB / 4];

//         big objects go into OldGen directly
        alloc2 = new byte[4 * _1MB];
//         big objects go into OldGen directly
        alloc2 = new byte[4 * _1MB];
//         4MB cannot go into OldGen anymore, minor fre.radon.jvm.GC happened to make Eden can store it
        alloc2 = new byte[4 * _1MB];
//         full fre.radon.jvm.GC happened
        alloc2 = new byte[4 * _1MB];
    }


    /**
     * VM options: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * <br/>
     * illustrate that when the same age objects take over
     * more than half space of Survivor(to), then the age equal and above
     * objects will go into OldGen
     */
    @Test
    public void testDynamicAgeIdentify() {

        byte[][] a = new byte[4][];

        a[0] = new byte[_1MB / 4];
        a[1] = new byte[_1MB / 4];
        a[2] = new byte[_1MB * 4];
        a[3] = new byte[_1MB * 4];

        a[3] = new byte[_1MB * 4];
//  FULL fre.radon.jvm.GC happened here
    }

    /**
     * VM options: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * <br/>
     * illustrate that when HandlePromotion happens
     */
    @Test
    public void testHandlePromotion() {

        byte[][] alloc = new byte[3][];

        for (int i = 0; i < 3; i++) {
            alloc[i] = new byte[2 * _1MB];
        }
    }
}
