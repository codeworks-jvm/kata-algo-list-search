import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {

    private final List<String> products;

    public ProductManager(List<String> products) {
        products.sort(Comparator.comparing(String::toString));
        this.products = products;
    }

    public boolean productIsPresent(String product) {
        return Collections.binarySearch(products, product) < 0;

        // we are having a performance issue in this method
    }
}
