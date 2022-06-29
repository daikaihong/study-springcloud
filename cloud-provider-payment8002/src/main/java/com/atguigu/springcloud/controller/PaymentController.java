package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.sys.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("payment/save")
    public Result save(Payment payment){
        int result = paymentService.save(payment);
        log.info("***插入成功***");
        return new Result().ok(result);
    }

    @GetMapping("payment/{id}")
    public Result getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.selectById(id);
        log.info("***查询成功***");
        return new Result().ok(payment + ", serverPort: " + serverPort);
    }

}
