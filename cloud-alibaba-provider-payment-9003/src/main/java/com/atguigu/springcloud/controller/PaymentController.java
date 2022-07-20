package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.sys.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "125121"));
        hashMap.put(2L, new Payment(1L, "125122"));
        hashMap.put(3L, new Payment(1L, "125123"));
    }

    @GetMapping("/payment/{id}")
    public Result<Payment> paymentResult(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        Result<Payment> result = new Result<Payment>().ok(payment);
        result.setMessage("serverPort: " + serverPort);
        return result;
    }
}
