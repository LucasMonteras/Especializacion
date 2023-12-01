package com.example.Checkoutservice.service.implementation;

import com.example.Checkoutservice.model.dto.Product;
import com.example.Checkoutservice.reposotory.FeignProductRepository;
import com.example.Checkoutservice.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {


    private FeignProductRepository feignProductRepository;



    public ProductService(FeignProductRepository feignProductRepository) {
        super();
        this.feignProductRepository = feignProductRepository;
    }



    @Override
    public Product getProduct(String id) {
        return feignProductRepository.getProductById(id);
    }

}
