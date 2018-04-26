package demo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理回调->控制对象访问
public class OrderInvocationHandler implements InvocationHandler {

	private IOrder order;
	private String username;

	public OrderInvocationHandler(String username, IOrder order) {
		this.username = username;
		this.order = order;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 判定是否调用了getOrderPrice
		if (method.getName().equals("getOrderPrice")) {
			// 判定权限
			if (!isChecked()) {
				throw new SecurityException("没有访问权限");
			}
			if (order.getOrderPrice() == null
					|| order.getOrderPrice().equals("")) {
				String orderPrice = OrderService.getOrderPriceById(order
						.getOrderId());
				this.order.setOrderPrice(orderPrice);
				return method.invoke(this.order, args);
			}
		}

		System.out.println("当前调用了: " + method.getName() + "方法");

		// 反射机制
		return method.invoke(this.order, args);
	}

	private boolean isChecked() {
		if (username == null || username.equals("")) {
			return false;
		}
		if (!username.equals("杜乙")) {
			System.out.println("不满足权限");
			return false;
		}
		return true;
	}

}
