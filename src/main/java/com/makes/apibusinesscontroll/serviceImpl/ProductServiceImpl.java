package com.makes.apibusinesscontroll.serviceImpl;


import com.makes.apibusinesscontroll.dto.request.ProductRequest;
import com.makes.apibusinesscontroll.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceImpl {

    public List<Product> findAllL();

    public Optional<Product> findById(Long id);

    public Product save(ProductRequest productRequest);

    public boolean getByName(String productName);

    public Product updateProduct(Long id,  ProductRequest request);

}
