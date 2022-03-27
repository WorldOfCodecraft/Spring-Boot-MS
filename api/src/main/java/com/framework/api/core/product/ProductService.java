package com.framework.api.core.product;

import org.springframework.web.bind.annotation.*;

public interface ProductService {

    /**
     * Sample usage, see below.
     * <p>
     * curl -X POST $HOST:$PORT/product \
     * -H "Content-Type: application/json" --data \
     * '{"productId":123,"name":"product 123","weight":123}'
     *
     * @param body A JSON representation of the new product
     * @return A JSON representation of the newly created product
     */
    @PostMapping(
            value = "/product",
            consumes = "application/json",
            produces = "application/json")
    Product createProduct(@RequestBody Product body);

    /**
     * Sample usage: "curl $HOST:$PORT/product/1".
     * <p>
     * MNote, p66
     *
     * @param productId Id of the product
     * @return the product, if found, else null
     * @PathVariable will map the value that's passed in the HTTP request to the parameter.
     * For example, an HTTP GET request to /product/123 will result in the getProduct() method being called
     * with the productId parameter set to 123
     */
    @GetMapping(
            value = "/product/{productId}",
            produces = "application/json")
    Product getProduct(@PathVariable int productId);

    /**
     * Sample usage: "curl -X DELETE $HOST:$PORT/product/1".
     *
     * The implementation should be idempotent; it should not report any failure if the entity is not found
     * @param productId Id of the product
     */
    @DeleteMapping(value = "/product/{productId}")
    void deleteProduct(@PathVariable int productId);
}
