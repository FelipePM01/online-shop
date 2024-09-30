package myapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
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
        Optional<Integer> rating,
        BigDecimal price,
        Optional<Integer> quantity_in_stock,
        ProductStatus status,
        Optional<Double> weight,
        String dimension,
        Instant date_added,
        Instant date_modified
    ) {
        return new Product()
            .title(title)
            .keywords(keywords)
            .description(description)
            .rating(rating.isPresent() ? rating.get() : null)
            .price(price)
            .quantityInStock(quantity_in_stock.isPresent() ? rating.get() : null)
            .status(status)
            .weight(weight.isPresent() ? weight.get() : null)
            .dimensions(dimension)
            .dateAdded(date_added)
            .dateModified(date_modified);
    }

    @Test
    public void tc1() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(5),
            BigDecimal.valueOf(0.0),
            Optional.empty(),
            ProductStatus.DISCONTINUED,
            Optional.of(0.0),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals("", result.getDescription());
    }

    @Test
    public void tc6() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aa",
            "",
            "",
            Optional.of(5),
            BigDecimal.valueOf(0.0),
            Optional.empty(),
            ProductStatus.DISCONTINUED,
            Optional.empty(),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }
}
