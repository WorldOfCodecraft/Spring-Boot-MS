package com.framework.api.core.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {

    /**
     * Sample usage: "curl $HOST:$PORT/product/1".
     *
     * MNote, p66
     * @PathVariable will map the value that's passed in the HTTP request to the parameter.
     * For example, an HTTP GET request to /product/123 will result in the getProduct() method being called
     * with the productId parameter set to 123
     *
     * @param productId Id of the product
     * @return the product, if found, else null
     */
    @GetMapping(
            value = "/product/{productId}",
            produces = "application/json")
    Product getProduct(@PathVariable int productId);
}
