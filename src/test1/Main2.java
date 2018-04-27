package test1;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        String phonename = OrderService.getOrderNameByUsername("赵晓");
        System.out.println(phonename);
        List<IOrder> iOrders = OrderService.getOrderlist();
//        IOrder order = iOrders.get(0);
        for (IOrder order : iOrders) {
            IOrder proxy = (IOrder) Proxy.newProxyInstance(order.getClass().getClassLoader(), order.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("getOrderName")) {
                        System.out.println(order.getOrderUserName());
                        if (order.getOrderUserName().equals("赵晓")) {
                            order.setOrderName("我已经被改变过了");
                        }
                        return method.invoke(order, args);
                    }
                    return method.invoke(order, args);
                }
            });
            System.out.println(proxy.getOrderName());

        }
    }
}
