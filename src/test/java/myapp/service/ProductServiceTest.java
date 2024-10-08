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
            .quantityInStock(quantity_in_stock.isPresent() ? quantity_in_stock.get() : null)
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
    public void tc2() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaa",
            Optional.of(4),
            BigDecimal.valueOf(0.1),
            Optional.of(0),
            ProductStatus.OUT_OF_STOCK,
            Optional.of(1.0),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals("aaaaaaaaaa", result.getDescription());
    }

    @Test
    public void tc3() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaa",
            Optional.of(0),
            BigDecimal.valueOf(0.1),
            Optional.of(1),
            ProductStatus.IN_STOCK,
            Optional.of(0.0),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals("aaaaaaaaaa", result.getDescription());
    }

    @Test
    public void tc4() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaa",
            Optional.of(1),
            BigDecimal.valueOf(0.1),
            Optional.of(1),
            ProductStatus.IN_STOCK,
            Optional.of(0.0),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals("aaaaaaaaaaa", result.getDescription());
    }

    @Test
    public void tc5() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaa",
            Optional.empty(),
            BigDecimal.valueOf(0.1),
            Optional.of(1),
            ProductStatus.IN_STOCK,
            Optional.of(0.0),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals("aaaaaaaaaaa", result.getDescription());
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

    @Test
    public void tc7() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
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

    @Test
    public void tc8() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
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

    @Test
    public void tc9() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "aaaaaaaaa",
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

    @Test
    public void tc10() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(6),
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

    @Test
    public void tc11() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(Integer.valueOf("b")),
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

    @Test
    public void tc12() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(Integer.valueOf((int) 0.6)),
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

    @Test
    public void tc13() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(-1),
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

    @Test
    public void tc14() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(5),
            BigDecimal.valueOf(Double.valueOf("a")),
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

    @Test
    public void tc15() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(5),
            BigDecimal.valueOf(47),
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

    @Test
    public void tc16() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(5),
            null,
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

    @Test
    public void tc17() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(5),
            BigDecimal.valueOf(-1),
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

    @Test
    public void tc18() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(5),
            BigDecimal.valueOf(0.0),
            Optional.of(Integer.valueOf("a")),
            ProductStatus.DISCONTINUED,
            Optional.empty(),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    public void tc19() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(5),
            BigDecimal.valueOf(0.0),
            Optional.of(Integer.valueOf((int) 0.1)),
            ProductStatus.DISCONTINUED,
            Optional.empty(),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    public void tc20() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
            "",
            "",
            Optional.of(5),
            BigDecimal.valueOf(0.0),
            Optional.of(-1),
            ProductStatus.DISCONTINUED,
            Optional.empty(),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    public void tc21() {
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
            Optional.empty(),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    public void tc22() {
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
            Optional.of(Double.valueOf("a")),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    public void tc23() {
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
            Optional.of(0.1),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    public void tc24() {
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
            Optional.of(-1.0),
            "",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    public void tc25() {
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
            Optional.empty(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            createdInstant,
            modifiedInstant
        );
        when(productRepository.save(product)).thenReturn(product);

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    public void tc26() {
        Instant createdInstant = Instant.parse("2024-09-25T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
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

    @Test
    public void tc27() {
        Instant createdInstant = Instant.parse("2024-09-23T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:01:00Z");

        Product product = createProductSample(
            "aaa",
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

    @Test
    public void tc28() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T09:59:00Z");

        Product product = createProductSample(
            "aaa",
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

    @Test
    public void tc29() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-24T10:00:00Z");

        Product product = createProductSample(
            "aaa",
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

    @Test
    public void tc30() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-23T10:00:00Z");

        Product product = createProductSample(
            "aaa",
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

    @Test
    public void tc31() {
        Instant createdInstant = Instant.parse("2024-09-24T10:00:00Z");
        Instant modifiedInstant = Instant.parse("2024-09-25T10:00:00Z");

        Product product = createProductSample(
            "aaa",
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
