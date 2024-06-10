package com.makes.apibusinesscontroll.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Lots")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Size(max = 255)
    @Column(name = "lot_number")
    private String loteNumber;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "exit_date")
    private LocalDate exitDate;

    @Column(name = "quantity")
    private Integer quantity;

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