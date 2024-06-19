package com.makes.apibusinesscontroll.services;


import com.makes.apibusinesscontroll.dto.request.ProductRequest;
import com.makes.apibusinesscontroll.models.Category;
import com.makes.apibusinesscontroll.models.Product;
import com.makes.apibusinesscontroll.models.Supplier;
import com.makes.apibusinesscontroll.repository.CategoryRepository;
import com.makes.apibusinesscontroll.repository.ProductRepository;
import com.makes.apibusinesscontroll.repository.SupplierRepository;
import com.makes.apibusinesscontroll.serviceImpl.ProductServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceImpl {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public List<Product> findAllL() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product save(ProductRequest dto) {
        Product product = new Product();

        Category category = new Category();
        Supplier supplier = new Supplier();

        Optional<Category> categoryOptionalOptional = categoryRepository.findById(dto.getCategory().getId());
        Optional<Supplier> supplierOptional = supplierRepository.findById(dto.getSupplier().getId());

        BeanUtils.copyProperties(dto, product,"modifiedBy");
        product.setCreationTime(LocalDateTime.now(ZoneId.of("America/Guatemala")));

        if(categoryOptionalOptional.isPresent() &&supplierOptional.isPresent()  ){
            product.setCategory(categoryOptionalOptional.get());
            product.setSupplier(supplierOptional.get());
        }
        return repository.save(product);
    }

    @Override
    public boolean getByName(String productName) {
        return repository.existsByName(productName);
    }

    @Override
    public Product updateProduct(Long id, ProductRequest request) {
        Product productResponse = new Product();

        Optional<Product> productOptional = repository.findById(id);
        if (!productOptional.isPresent()) {
            return productResponse = null;
        }
        Product productModel = productOptional.get();
        BeanUtils.copyProperties(request, productModel,"createdBy");
        productModel.setModificationTime(LocalDateTime.now(ZoneId.of("America/Guatemala")));
        productResponse = repository.save(productModel);
        return productResponse;
    }


}
