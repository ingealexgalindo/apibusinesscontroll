package com.makes.apibusinesscontroll.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Products", schema = "microserviceProducts")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Size(max = 255)
    @Column(name = "barcode")
    private String barcode;

    @Size(max = 255)
    @Column(name = "sku")
    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_of_measure_id")
    private Unit unitOfMeasure;

    @Size(max = 255)
    @Column(name = "image_url")
    private String imageUrl;

    @Size(max = 255)
    @Column(name = "warranty_period")
    private String warrantyPeriod;

    @Column(name = "active")
    private Boolean active;

    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;

    @Size(max = 255)
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Column(name = "modification_time")
    private LocalDateTime modificationTime;

}