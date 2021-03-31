package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Iproducer proxy = (Iproducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                double money = (double)args[0];
                if (method.getName().equals("sell")){
                    returnValue = method.invoke(producer, money * 0.6d);
                }
                return returnValue;
            }
        });
        double value = proxy.sell(10000);
        System.out.println(value);

    }
}
class Producer implements Iproducer{
    public double sell(double money){
        System.out.println("producer get " + money);
        return money;
    }
}
interface Iproducer{
    double sell(double money);
}