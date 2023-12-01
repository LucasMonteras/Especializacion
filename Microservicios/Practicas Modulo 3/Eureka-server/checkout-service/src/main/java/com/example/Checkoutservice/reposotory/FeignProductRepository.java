package com.example.Checkoutservice.reposotory;

import com.example.Checkoutservice.model.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="products-service")
public interface FeignProductRepository {

    @RequestMapping(method= RequestMethod.GET,value ="/products")
    Product getProductById(@RequestParam String id);
}
