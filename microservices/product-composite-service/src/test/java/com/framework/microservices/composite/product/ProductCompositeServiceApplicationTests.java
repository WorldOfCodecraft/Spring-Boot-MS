package com.framework.microservices.composite.product;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static reactor.core.publisher.Mono.just;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.framework.api.composite.product.ProductAggregate;
import com.framework.api.composite.product.RecommendationSummary;
import com.framework.api.composite.product.ReviewSummary;
import com.framework.api.core.product.Product;
import com.framework.api.core.recommendation.Recommendation;
import com.framework.api.core.review.Review;
import com.framework.api.exceptions.InvalidInputException;
import com.framework.api.exceptions.NotFoundException;
import com.framework.microservices.composite.product.services.ProductCompositeIntegration;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ProductCompositeServiceApplicationTests {

    private static final int PRODUCT_ID_OK = 1;
    private static final int PRODUCT_ID_NOT_FOUND = 2;
    private static final int PRODUCT_ID_INVALID = 3;

    @Autowired
    private WebTestClient client;

    /**
     * MNote, p87
     * To test the composite product API in isolation, we need to mock its dependencies
     */
    @MockBean
    private ProductCompositeIntegration compositeIntegration;

    /**
     * MNote, p87
     * We use Mockito to do this
     */
    @BeforeEach
    void setUp() {
        when(compositeIntegration.getProduct(PRODUCT_ID_OK))
                .thenReturn(new Product(PRODUCT_ID_OK, "name", 1, "mock-address"));
        when(compositeIntegration.getRecommendations(PRODUCT_ID_OK))
                .thenReturn(singletonList(new Recommendation(PRODUCT_ID_OK, 1, "author", 1, "content", "mock address")));
        when(compositeIntegration.getReviews(PRODUCT_ID_OK))
                .thenReturn(singletonList(new Review(PRODUCT_ID_OK, 1, "author", "subject", "content", "mock address")));

        when(compositeIntegration.getProduct(PRODUCT_ID_NOT_FOUND))
                .thenThrow(new NotFoundException("NOT FOUND: " + PRODUCT_ID_NOT_FOUND));
        when(compositeIntegration.getProduct(PRODUCT_ID_INVALID))
                .thenThrow(new InvalidInputException("INVALID: " + PRODUCT_ID_INVALID));
    }

    @Test
    void contextLoads() {
    }

    @Test
    void createCompositeProduct1() {
        ProductAggregate compositeProduct = new ProductAggregate(1, "name", 1, null, null, null);

        postAndVerifyProduct(compositeProduct, OK);
    }

    @Test
    void createCompositeProduct2() {
        ProductAggregate compositeProduct = new ProductAggregate(1, "name", 1,
                singletonList(new RecommendationSummary(1, "a", 1, "c")),
                singletonList(new ReviewSummary(1, "a", "s", "c")), null);

        postAndVerifyProduct(compositeProduct, OK);
    }

    @Test
    void deleteCompositeProduct() {
        ProductAggregate compositeProduct = new ProductAggregate(1, "name", 1,
                singletonList(new RecommendationSummary(1, "a", 1, "c")),
                singletonList(new ReviewSummary(1, "a", "s", "c")), null);

        postAndVerifyProduct(compositeProduct, OK);

        //Invoke delete methods twice to see if it works well during failures
        deleteAndVerifyProduct(compositeProduct.getProductId(), OK);
        deleteAndVerifyProduct(compositeProduct.getProductId(), OK);
    }

    /**
     * MNote, p87
     * <p>
     * 1. Uses WebTestClient API to set up the URL to call "/product-composite/" + PRODUCT_ID_OK
     * 2. Specify the accepted response format, JSON
     * 3. Executing the request using the exchange() method
     * 4. Verifies that the response status is OK (200)
     * 5. Verifies the response format actually is JSON
     * 6. Inspects the response body
     */
    @Test
    void getProductById() {

        getAndVerifyProduct(PRODUCT_ID_OK, OK)
                .jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK)
                .jsonPath("$.recommendations.length()").isEqualTo(1)
                .jsonPath("$.reviews.length()").isEqualTo(1);
    }

    @Test
    void getProductNotFound() {

        getAndVerifyProduct(PRODUCT_ID_NOT_FOUND, NOT_FOUND)
                .jsonPath("$.path").isEqualTo("/product-composite/" + PRODUCT_ID_NOT_FOUND)
                .jsonPath("$.message").isEqualTo("NOT FOUND: " + PRODUCT_ID_NOT_FOUND);
    }

    @Test
    void getProductInvalidInput() {

        getAndVerifyProduct(PRODUCT_ID_INVALID, UNPROCESSABLE_ENTITY)
                .jsonPath("$.path").isEqualTo("/product-composite/" + PRODUCT_ID_INVALID)
                .jsonPath("$.message").isEqualTo("INVALID: " + PRODUCT_ID_INVALID);
    }

    private WebTestClient.BodyContentSpec getAndVerifyProduct(int productId, HttpStatus expectedStatus) {
        return client.get()
                .uri("/product-composite/" + productId)
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus)
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBody();
    }

    private void postAndVerifyProduct(ProductAggregate compositeProduct, HttpStatus expectedStatus) {
        client.post()
                .uri("/product-composite")
                .body(just(compositeProduct), ProductAggregate.class)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus);
    }

    private void deleteAndVerifyProduct(int productId, HttpStatus expectedStatus) {
        client.delete()
                .uri("/product-composite/" + productId)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus);
    }
}
