package fre.radon.jvm.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link ArrayList#subList(int, int)} 使用注意事项
 * @author Radon Freedom
 * created at 2018.11.30 15:35
 */

public class SublistTest {

    @Test
    public void testSublist(){

        List<String> list = new ArrayList<>();
        list.add("s");

//        list.subList() 返回的SubList是ArrayList类内部的私有类，如果是用返回的SubList来CURD就没事
        List<String> subList = (ArrayList<String>) list.subList(0, 1);
        subList.add("d");
        System.out.println(list.get(1));

//        然是如果父List发生变化，再用SubList来CURD会抛异常
        list.remove(0);

        subList.add("a");

    }
}
