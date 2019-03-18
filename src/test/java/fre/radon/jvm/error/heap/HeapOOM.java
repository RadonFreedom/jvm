package fre.radon.jvm.error.heap;

import java.util.ArrayList;

/**
 * 堆上内存超过-Xmx设定限制抛出OOM。 <br>
 * VM Args: -Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError
 * "-XX:+HeapDumpOnOutOfMemoryError" is to set VM to dump java_pid*.hprof
 * @author Radon Freedom
 */

public class HeapOOM {

    public static void main(String[] args) {

        ArrayList<HeapOOM> objList = new ArrayList<>();

        while (true){
            objList.add(new HeapOOM());
        }
    }
}
