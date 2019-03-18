package fre.radon.jvm.error.metaspace;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * VM options: -XX:MetaspaceSize=16M -XX:MaxMetaspaceSize=16M
 *
 * @author Radon Freedom
 */

public class JavaMethodAreaOOM {

    public static void main(String[] args) {

        while (true) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(JavaMethodAreaOOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)
                    (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
            enhancer.create();
        }
    }
}
