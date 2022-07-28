package Z_OOD.AmazonOnlineShoppingSystem;


import java.util.HashMap;
import java.util.List;

// Catalog will implement Search to facilitate searching of products
class SearchInterfaceAndCatalog {

    public interface Search {
        public List<Product> searchProductsByName(String name);
        public List<Product> searchProductsByCategory(String category);
    }

    public class Catelog implements Search {
        HashMap<String, List<Product>> productNames;
        HashMap<String, List<Product>> productCategories;

        public List<Product> searchProductsByName(String name) {
            return productNames.get(name);
        }

        public List<Product> searchProductsByCategory(String category) {
            return productCategories.get(category);
        }
    }
}
