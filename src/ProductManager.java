import java.util.List;

public class ProductManager {

    private final List<String> products;

    public ProductManager(List<String> products) {
        this.products = products;
    }

    public boolean productIsPresent(String product) {
        return products.contains(product);

        // we are having a performance issue in this method
    }
}
