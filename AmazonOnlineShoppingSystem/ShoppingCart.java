package Z_OOD.AmazonOnlineShoppingSystem;

import java.util.List;

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
                t.updateQuantity(quantity);
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