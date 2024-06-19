package com.makes.apibusinesscontroll.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    @JsonBackReference
    private Supplier supplier;

    @Size(max = 50)
    @Column(name = "unit_of_measure", length = 50)
    private String unitOfMeasure;

    @Size(max = 100)
    @Column(name = "barcode", length = 100)
    private String barcode;

    @Size(max = 100)
    @Column(name = "sku", length = 100)
    private String sku;

    @Column(name = "min_stock_level")
    private Integer minStockLevel;

    @Column(name = "max_stock_level")
    private Integer maxStockLevel;

    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Size(max = 255)
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modification_time")
    private LocalDateTime modificationTime;

}