package com.framework.microservices.core.product.persistence;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, String> {
    /**
     * MNote, p150
     * Spring Data supports defining extra query methods based on naming conventions for the signature of the method.
     * <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories.query-methods.query-creation">Ref</a>
     *
     * @param productId
     * @return
     */
    Optional<ProductEntity> findByProductId(int productId);
}
