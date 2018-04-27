import demo1.GSShopPhone;
import demo1.WJProxy;

import demo4.IOrder;
import demo4.OrderInvocationHandler;
import demo4.OrderService;

import java.lang.reflect.Proxy;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // GSShopPhone shopPhone = new GSShopPhone();
        // WJProxy proxy = new WJProxy(shopPhone);
        // proxy.shop("IPhone 8 价格：6880");

        // 测试：查询所有数据
//         OrderService orderService = new OrderService();
//         List<OrderBean> orderList = orderService.getOrderList();
//         for (OrderBean orderBean : orderList) {
//         System.out.println(orderBean.toString());
//         }

//         String  price =OrderService.getOrderPriceById("2");
//         System.out.println(price);
        // 做一件事情：控制对象的访问，权限管理（你的名称是：杜乙->允许你查询）
        // 一般情况下没有必要一次性查询这么多字段，刚开始查询字段（order_id、order_name）
        // 第一个条件：你必须是(杜乙)同学
        // 第二个条件：开始查询字段（order_id、order_name），后面用到了我再查询
        // 解决方案：代理模式
        // 第一步：定义->目标接口->IOrder
        // 第二步：定义->具体实现类->SubjectOrder
        // 第三步：定义->代理对象->ProxyOrder
//         OrderService orderService = new OrderService();
//         List<IOrder> orderList = orderService.getOrderList("lisan");
//         for (IOrder orderBean : orderList) {
//         System.out.println("订单ID: " + orderBean.getOrderId() + "订单名称: "
//         + orderBean.getOrderName() + " 订单价格："
//         + orderBean.getOrderPrice());
//         }
        // 动态代理
        // 角色划分
        // 目标接口：IOrder
        // 目标对象：OrderBean
        // 代理对象：proxy
        List<IOrder> orderList = OrderService.getOrderList();
        for(IOrder order:orderList){
            IOrder proxy = (IOrder) Proxy.newProxyInstance(order.getClass()
                            .getClassLoader(), order.getClass().getInterfaces(),
                    new OrderInvocationHandler("杜乙", order));

            System.out.println("订单ID: " + proxy.getOrderId());
            System.out.println("订单名称: " + proxy.getOrderName());
            System.out.println("订单价格: " + proxy.getOrderPrice());
        }
        IOrder order = orderList.get(0);
        // 创建代理类
        // 参数一：类加载器
        // 参数二：代理接口
        // 参数三：代理回调
        // 说白了：就是方法监听(触发方法，必需调用方法才会回调，不会)
        IOrder proxy = (IOrder) Proxy.newProxyInstance(order.getClass()
                        .getClassLoader(), order.getClass().getInterfaces(),
                new OrderInvocationHandler("杜乙", order));

        System.out.println("订单ID: " + proxy.getOrderId());
        System.out.println("订单名称: " + proxy.getOrderName());
        System.out.println("订单价格: " + proxy.getOrderPrice());

        //10:15分，继续，中场休息15分钟，洗澡，洗衣服
        //代理模式变种->后面8月31日开班之后，给补课，不一些架构设计（设计模式：具体的场景应用）
    }
}
