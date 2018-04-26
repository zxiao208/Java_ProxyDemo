package demo4;

//目标对象
public class OrderBean implements IOrder {
	
	private String orderId;
	private String orderName;
	private String orderPrice;
	private String orderUserName;

	public OrderBean() {
		
	}

	public OrderBean(String orderId, String orderName, String orderPrice,
			String orderUserName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderUserName = orderUserName;
	}

	@Override
	public String getOrderId() {
		return orderId;
	}

	@Override
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String getOrderName() {
		return orderName;
	}

	@Override
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String getOrderPrice() {
		return orderPrice;
	}

	@Override
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Override
	public String getOrderUserName() {
		return orderUserName;
	}

	@Override
	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", orderName=" + orderName
				+ ", orderPrice=" + orderPrice + ", orderUserName="
				+ orderUserName + "]";
	}

}
