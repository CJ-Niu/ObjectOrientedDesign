package Z_OOD.AmazonOnlineShoppingSystem;
import java.util.Date;
import java.util.List;

// Users will add items to the shopping cart and place an order to buy all the items in the cart
class ShoppingCartItemOrderAndOrderLog {

    public class Item {
        private String productID;
        private int quantity;
        private double price;

        public boolean updateQuantity(int quantity) {
            this.quantity = quantity;
            return true;
        }
    }

    public class ShoppingCart {
        // each shopping cart has a list of items
        private List<Item> items;

        // method
        public boolean addItem(Item item){
            items.add(item);
            return true;
        }

        public boolean removeItem(Item item){
            for (Item t : items) {
                if (t.equals(item)) {
                    items.remove(t);
                    return true;
                }
            }
            return false;
        }

        public boolean updateItemQuantity(Item item, int quantity) {
            for (Item t : items) {
                if (t.equals(item)) {
                    t.quantity = quantity;
                    return true;
                }
            }
            return false;
        }

        public List<Item> getItems() {
            return items;
        }

        public boolean checkout() {
            // implementations
            return true;
        };
    }

    public class OrderLog {
        private String orderNumber;
        private Date creationDate;
        private OrderStatus status;
    }

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
    }
}
