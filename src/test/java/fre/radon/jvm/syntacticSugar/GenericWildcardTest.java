package fre.radon.jvm.syntacticSugar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 例证PECS原则： Producer Extends Consumer Super
 *
 * @author Radon Freedom
 * created at 2018.12.03 10:44
 */

public class GenericWildcardTest {

    @Test
    public void upperBoundsWildcard(){

        List<? extends Fruit> fruits = new ArrayList<>();

//        fruits.add(new Fruit());  // compile error!

//      compile OK!
        Food fruit = fruits.get(0);
        Fruit fruit1 = fruits.get(0);
    }

    @Test
    public void lowerBoundsWildcard(){

        List<? super Fruit> fruits = new ArrayList<>();

//      compile OK!
        fruits.add(new Fruit());
        fruits.add(new Apple());

//        Fruit fruit = fruits.get(0);  //compile error!
    }

    private class Food{}
    private class Fruit extends Food{}
    private class Apple extends Fruit{}
}
