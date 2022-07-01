package com.atguigu.springcloud.service;

import com.atguigu.springcloud.sys.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("payment/{id}")
    public Result getPaymentById(@PathVariable("id") Long id);

}
