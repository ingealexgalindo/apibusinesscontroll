package com.makes.apibusinesscontroll.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Suppliers", schema = "microserviceProducts")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Size(max = 255)
    @Column(name = "contact_name")
    private String contactName;

    @Size(max = 255)
    @Column(name = "contact_email")
    private String contactEmail;

    @Size(max = 50)
    @Column(name = "contact_phone", length = 50)
    private String contactPhone;

    @Lob
    @Column(name = "address")
    private String address;

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