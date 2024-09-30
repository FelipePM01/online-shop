package myapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.Instant;
import myapp.domain.Product;
import myapp.domain.enumeration.ProductStatus;
import myapp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    public static Product createProductSample(
        String title,
        String keywords,
        String description,
        int rating,
        BigDecimal price,
        int quantity_in_stock,
        ProductStatus status,
        Double weight,
        String dimension,
        Instant date_added,
        Instant date_modified
    ) {
        return new Product()
            .title(title)
            .keywords(keywords)
            .description(description)
            .rating(rating)
            .price(price)
            .quantityInStock(quantity_in_stock)
            .status(status)
            .weight(weight)
            .dimensions(dimension)
            .dateAdded(date_added)
            .dateModified(date_modified);
    }

    @Test
    public void saveProduct_success() {
        Product product = createProductSample(null, null, "description1", 0, null, 0, null, null, null, null, null);
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals("description1", result.getDescription());
    }
}
