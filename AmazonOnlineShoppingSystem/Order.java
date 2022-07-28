package Z_OOD.AmazonOnlineShoppingSystem;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderNumber;
    private OrderStatus status;
    private Date orderDate;
    private List<OrderLog> orderLog;

    public boolean sendForShipment() {
        // implementation
        return true;
    }

    //public boolean makePayment(Payment payment);

    public boolean addOrderLog(OrderLog orderLog) {
        // implementation
        return true;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }
}
