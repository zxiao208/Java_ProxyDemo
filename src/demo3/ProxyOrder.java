package demo3;


//代理对象
public class ProxyOrder implements IOrder {

	private IOrder order;
	private String username;

	public ProxyOrder(String username, IOrder order) {
		this.username = username;
		this.order = order;
	}

	@Override
	public String getOrderId() {
		return order.getOrderId();
	}

	@Override
	public void setOrderId(String orderId) {
		order.setOrderId(orderId);
	}

	@Override
	public String getOrderName() {
		return order.getOrderName();
	}

	@Override
	public void setOrderName(String orderName) {
		order.setOrderName(orderName);
	}

	@Override
	public String getOrderPrice() {
		if (!isChecked()) {
			return "";
		}
		setOrderPrice(OrderService.getOrderPriceById(order.getOrderId()));
		return order.getOrderPrice();
	}

	private boolean isChecked() {
		if (username == null || username.equals("")) {
			return false;
		}
		if (!username.equals("赵晓")) {
			System.out.println("不满足权限");
			return false;
		}
		return true;
	}

	@Override
	public void setOrderPrice(String orderPrice) {
		order.setOrderPrice(orderPrice);
	}

	@Override
	public String getOrderUserName() {
		return order.getOrderUserName();
	}

	@Override
	public void setOrderUserName(String orderUserName) {
		order.setOrderUserName(orderUserName);
	}

}
