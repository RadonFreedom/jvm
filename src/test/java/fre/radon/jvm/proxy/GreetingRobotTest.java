package fre.radon.jvm.proxy;

import java.lang.reflect.Proxy;

/**
 * @author Radon Freedom
 * created at 2018.12.23 12:39
 */

public class GreetingRobotTest {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        GreetingRobot robot = (GreetingRobot) Proxy.newProxyInstance(
                        GreetingRobotImpl.class.getClassLoader(),
                        GreetingRobotImpl.class.getInterfaces(),
                        new GreetingRobotInvocationHandler(new GreetingRobotImpl()));

        robot.sayHi("Tony");
    }
}
