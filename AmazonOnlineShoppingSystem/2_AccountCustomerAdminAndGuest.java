package Z_OOD.AmazonOnlineShoppingSystem;

import java.util.List;

// These classes represent different people that interact with our system
class AccountCustomerAdminAndGuest {

    public class Account {
        private String userName;
        private String passWord;
        private AccountStatus status;
        private String name;
        private Address shippingAddress;
        private String email;
        private String phone;

        // private List<CreditCard> creditCards;
        // private List<ElectronicBankTransfer> bankAccounts;

        public boolean addProduct(Product product) {
            Product p = new Product();
            // implementation...
            return true;
        }

        public boolean addProductReview(ProductReview review) {
            // implementation...
            return true;
        }

        // public boolean resetPassword();
    }

    public abstract class Customer {
        private ShoppingCart cart;
        private Order order;

        public abstract ShoppingCart getShoppingCart();
        public abstract boolean addItemToCart(Item item);
        public abstract boolean removeItemFromCart(Item item);
    }

    public class Guest extends Customer {

        ShoppingCart cart = new ShoppingCart();

        public ShoppingCart getShoppingCart() {
            return cart;
        }

        public boolean addItemToCart(Item item) {
            cart.addItem(item);
            return true;
        }

        public boolean removeItemFromCart(Item item) {
            return cart.removeItem(item);
        }

        public boolean registerAccount() {
            // implementation
            return true;
        }
    }

    public class Member extends Customer {
        private Account account;

        ShoppingCart cart = new ShoppingCart();

        public ShoppingCart getShoppingCart() {
            return cart;
        }

        public boolean addItemToCart(Item item) {
            cart.addItem(item);
            return true;
        }

        public boolean removeItemFromCart(Item item) {
            return cart.removeItem(item);
        }

        public OrderStatus placeOrder(Order order) {
            return order.getOrderStatus();
        }
    }
}
