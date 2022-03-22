package com.framework.microservices.core.recommendation.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * MNote, p149
 * The CrudRepository base class provides standard methods for performing basic
 * create, read, update, and delete operations on the data stored in the databases
 */
public interface RecommendationRepository extends CrudRepository<RecommendationEntity, String> {
    List<RecommendationEntity> findByProductId(int productId);
}
