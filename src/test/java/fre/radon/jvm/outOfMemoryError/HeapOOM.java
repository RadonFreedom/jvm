package fre.radon.jvm.outOfMemoryError;

import java.util.ArrayList;

/**
 * Test about heap OutOfMemoryError. <br>
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
