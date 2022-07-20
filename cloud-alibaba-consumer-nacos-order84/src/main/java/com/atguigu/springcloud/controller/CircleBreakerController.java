package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.sys.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/{id}")
    @SentinelResource(value = "fallback", fallback = "handleFallBack", blockHandler = "blockHandler")
    // fallback 只负责业务异常   blockHandler 只负责控制台配置违规
    public Result<Payment> fallback(@PathVariable("id") Long id) throws IllegalAccessException {
        Result<Payment> result = restTemplate.getForObject(serviceUrl + "/payment/" + id, Result.class);

        if(id == 4) {
            throw new IllegalAccessException("illegalAccessException, 非法参数");
        }else if (result.getData() == null) {
            throw new NullPointerException("new NullPointerException, 空指针异常");
        }

        return result;
    }

    public Result handleFallBack(@PathVariable("id") Long id, Throwable e) {
        return new Result<Payment>().error("handleFallBack异常");
    }


    // OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping("consumer/payment/{id}")
    public Result<Payment> payment(@PathVariable("id") Long id){
        return paymentService.payment(id);
    }
}
