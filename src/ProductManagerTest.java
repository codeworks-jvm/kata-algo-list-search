import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void productIsPresentShouldBeFastForBigList() {
        // GIVEN
        List<String> products = new ArrayList<>();

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random;

        for (int i = 0; i < 10000000; i++) {
            random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            products.add(generatedString);
        }

        ProductManager productManager = new ProductManager(products);

        // WHEN
        Instant start = Instant.now();
        productManager.productIsPresent("myProduct");
        Instant finish = Instant.now();

        // THEN
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("It takes : " + timeElapsed + "ms");
        assertTrue(timeElapsed < 1);
    }
}