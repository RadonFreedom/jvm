package fre.radon.jvm.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * can only run before(included) JDK7. <br/>
 * VM options: -Xms10m -Xmx10m -XX:PermSize=2M -XX:MaxPermSize=2M -XX:+HeapDumpOnOutOfMemoryError
 * @author Radon Freedom
 */

@Deprecated
public class RuntimeStringConstantPoolOOM {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        int i = 0;

        while (true){
            list.add(String.valueOf(i).intern());
        }
    }
}
