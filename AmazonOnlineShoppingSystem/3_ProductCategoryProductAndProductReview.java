package Z_OOD.AmazonOnlineShoppingSystem;

// Here are the classes related to a product
class ProductCategoryProductAndProductReview {

    public class ProductCategory {
        private String name;
        private String description;
    }

    public class ProductReview {
        private int rating;
        private String review;

        // private Member reviewer;
    }

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
}
