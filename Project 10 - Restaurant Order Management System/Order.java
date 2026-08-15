import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

public class Order{
    private String orderId;
    private Customer customer;
    private Map<MenuItem, Integer> orderedItems = new HashMap<>();
    private OrderStatus orderStatus = OrderStatus.PENDING;
    private BigDecimal totalAmount;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<MenuItem, Integer> getOrderedItems() {
        return orderedItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customer=" + customer +
                ", orderedItems=" + orderedItems +
                ", orderStatus=" + orderStatus +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
