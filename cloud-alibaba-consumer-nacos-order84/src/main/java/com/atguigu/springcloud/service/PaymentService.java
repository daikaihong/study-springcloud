package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.PaymentFallbackServiceImpl;
import com.atguigu.springcloud.sys.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    Result payment(@PathVariable("id") Long id);

}
