package fre.radon.jvm.syntacticSugar;

import org.junit.Test;

import java.util.*;

/**
 * 各种语法糖测试，可以用IDE打开.class文件 或者使用 init -v -p 查看反编译结果
 *
 * @author Radon Freedom
 * created at 2018.11.25 9:47
 */

public class SyntacticSugarTest {

    /**
     * 泛型的语法糖测试
     */
    @Test
    public void sugar1(){

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "abs");
        map.put(2, "SHR");

        String str1 = map.get(1);
        String str2 = map.get(2);
    }

    /**
     * 自动装箱类的语法糖测试
     */
    @Test
    public void sugar2(){

        Integer a = 1;
        Integer b = 126;
        Integer c = 127;
        Integer d = 127;
        Integer e = 128;
        Integer f = 128;
        Long g = 127L;

        System.out.println(c == d);
        System.out.println(e == f);
//        以下语句不能被编译
//        System.out.println(c == g);
    }

    /**
     * 迭代器的语法糖测试 <br/>
     * 参考阿里巴巴JavaManual的集合处理第五条：
     * 不要在foreach循环里进行元素的remove/add操作
     * @see Iterator#remove()
     * @see ArrayList#iterator()
     */
    @Test
    public void sugar3(){

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

//        在JAVA8里面 Collection 新增了一个利用 lambda 表达式过滤条件的删除元素方法
//        list.removeIf("1"::equals);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
            if ("1".equals(item)) {
                /*下面语句不仅仅会删除cursor走过的上一个元素
                还会把cursor值退回上次的值(源码中的 lastRet)
                而且会把 lastRet 置为 -1
                这就解释了为什么不能连续两次调用 Iterator#remove() 方法
                 */
                iterator.remove();
            }
        }
            /*下面的代码会得到错误的结果，
            因为iterator在没有把cursor退回的情况下就把元素删除了，
            所以当执行 list.remove(s); 其实cursor的值为1，导致
            public boolean hasNext() {
                return cursor != size;
            }
            方法返回false，foreach语句执行结束
            */
//        for (String s : list) {
//            System.out.println(s);
//            if ("1".equals(s))
//                list.remove(s);
//        }
    }

    /**
     * 变长参数语法糖测试，可以用 init -v -p 查看反编译结果
     */
    @Test
    public void sugar4(){

        variableParas();
    }

    private void variableParas(Object ...a){

    }
}









