package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.sys.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @GetMapping("/consumer/payment/save")
    public Result<Payment> save(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/save", payment, Result.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/" + id, Result.class);
    }

    @GetMapping("/comsumer/payment/getForEntity/{id}")
    public Result getPaymentBody(@PathVariable("id") Long id) {

        ResponseEntity<Result> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, Result.class);

        if(entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }

       return new Result().error("操作失败!");
    }

}
