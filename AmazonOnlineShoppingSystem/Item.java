package Z_OOD.AmazonOnlineShoppingSystem;

public class Item {
    private String productID;
    private int quantity;
    private double price;

    public boolean updateQuantity(int quantity) {
        this.quantity = quantity;
        return true;
    }
}
