package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfoOK(Integer id) {
        return "PaymentFallbackService fall back paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentFallbackService fall back paymentInfoTimeOut";
    }
}
