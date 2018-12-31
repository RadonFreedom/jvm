package fre.radon.jvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Radon Freedom
 * created at 2018.12.23 12:35
 */

public class GreetingRobotInvocationHandler implements InvocationHandler {

    private final GreetingRobotImpl greetingRobotImpl;

    public GreetingRobotInvocationHandler(GreetingRobotImpl greetingRobotImpl) {
        this.greetingRobotImpl = greetingRobotImpl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object retVal = method.invoke(greetingRobotImpl, args);
        System.out.println("I am a greeting robot!");

        return retVal;
    }
}
