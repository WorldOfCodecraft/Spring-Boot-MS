package com.framework.microservices.core.review.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewRepository extends CrudRepository<ReviewEntity, Integer> {

    //MNote, p150
    //Since SQL databases are transactional, we have to specify the default transaction type
    @Transactional(readOnly = true)
    List<ReviewEntity> findByProductId(int productId);
}
