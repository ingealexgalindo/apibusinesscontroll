package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.mapper.ProductMapper;
import com.makes.apibusinesscontroll.dto.ProductDto;
import com.makes.apibusinesscontroll.models.*;
import com.makes.apibusinesscontroll.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final UnitRepository unitRepository;
    private final SupplierRepository supplierRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, BrandRepository brandRepository, UnitRepository unitRepository, SupplierRepository supplierRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
        this.unitRepository = unitRepository;
        this.supplierRepository = supplierRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::toDto).orElse(null);
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product.setCreationTime(LocalDateTime.now());
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    // Mapea y actualiza las propiedades del producto existente
                    productMapper.updateEntityFromDto(productDto, existingProduct);

                    // Obtener y asignar las entidades relacionadas desde la base de datos
                    if (productDto.getCategoryId() != null) {
                        Category category = categoryRepository.findById(productDto.getCategoryId())
                                .orElseThrow(() -> new RuntimeException("Category not found"));
                        existingProduct.setCategory(category);
                    }

                    if (productDto.getBrandId() != null) {
                        Brand brand = brandRepository.findById(productDto.getBrandId())
                                .orElseThrow(() -> new RuntimeException("Brand not found"));
                        existingProduct.setBrand(brand);
                    }

                    if (productDto.getSupplierId() != null) {
                        Supplier supplier = supplierRepository.findById(productDto.getSupplierId())
                                .orElseThrow(() -> new RuntimeException("Supplier not found"));
                        existingProduct.setSupplier(supplier);
                    }

                    if (productDto.getUnitOfMeasureId() != null) {
                        Unit unit = unitRepository.findById(productDto.getUnitOfMeasureId())
                                .orElseThrow(() -> new RuntimeException("Unit not found"));
                        existingProduct.setUnitOfMeasure(unit);
                    }

                    existingProduct.setModificationTime(LocalDateTime.now());
                    // Guarda los cambios en la base de datos
                    Product updatedProduct = productRepository.save(existingProduct);
                    return productMapper.toDto(updatedProduct);
                })
                .orElse(null);
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}