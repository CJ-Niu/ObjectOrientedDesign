package Z_OOD.AmazonOnlineShoppingSystem;

public class Product {
    private String productID;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    private int availableItemCount;

    private Account seller;

    public int getAvailableItemCount() {
        return availableItemCount;
    }
    public boolean updatePrice(double newPrice) {
        this.price = newPrice;
        return true;
    }
}
