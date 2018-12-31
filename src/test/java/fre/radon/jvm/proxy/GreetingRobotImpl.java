package fre.radon.jvm.proxy;

/**
 * @author Radon Freedom
 * created at 2018.12.23 12:33
 */

public class GreetingRobotImpl implements GreetingRobot {


    @Override
    public void sayHi(String personName) {

        System.out.println("Hi, " + personName + "!");
    }
}
