package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;



}
