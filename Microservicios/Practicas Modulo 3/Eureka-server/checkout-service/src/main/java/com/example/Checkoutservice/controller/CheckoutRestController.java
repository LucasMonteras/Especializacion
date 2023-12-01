package com.example.Checkoutservice.controller;

import com.example.Checkoutservice.model.Checkout;
import com.example.Checkoutservice.service.ICheckoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value ="/checkout")
public class CheckoutRestController {
    private ICheckoutService checkoutService;


    public CheckoutRestController(ICheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }



    @GetMapping()
    public Checkout getCheckout(@RequestParam List<String> productIds) {

        return checkoutService.buildCheckout(productIds);

    }

}
