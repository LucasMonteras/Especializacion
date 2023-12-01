package com.example.Checkoutservice.service;

import com.example.Checkoutservice.model.Checkout;

import java.util.List;

public interface ICheckoutService {

    public Checkout buildCheckout(List<String> productIds);
}
