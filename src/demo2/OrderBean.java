package demo2;

//订单对象
public class OrderBean {
	
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderUserName() {
		return orderUserName;
	}

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
