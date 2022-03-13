package com.framework.microservices.core.product.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MNote, p147
 * Document marks the class used for MongoDB
 */
@Document(collection = "products")
public class ProductEntity {

    //MNote, p147
    //Spring Data can delegate this responsibility to the database engine or handle it on its own
    @Id
    private String id;

    /**
     * MNote, p147
     * Used to implement optimistic locking, allowing Spring Data to verify that updates of an entity in the database
     * do not overwrite a concurrent update.
     *
     * Since we only implement APIs for create, read, and delete operations,
     * we will not expose the version field in the API.
     */
    @Version
    private Integer version;

    @Indexed(unique = true)
    private int productId;

    private String name;
    private int weight;

    public ProductEntity() {
    }

    public ProductEntity(int productId, String name, int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
