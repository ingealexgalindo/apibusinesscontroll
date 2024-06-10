package com.makes.apibusinesscontroll.serviceImpl;

import com.makes.apibusinesscontroll.dto.request.ProductRequest;
import com.makes.apibusinesscontroll.models.Product;
import com.makes.apibusinesscontroll.models.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductServiceImpl {

    public List<Product> findAllL();

    public Optional<Product> findById(Long id);

    public Product save(Product role);

    public boolean getByName(String productName);

    public Product updateProduct(Long id,  ProductRequest request);

}
