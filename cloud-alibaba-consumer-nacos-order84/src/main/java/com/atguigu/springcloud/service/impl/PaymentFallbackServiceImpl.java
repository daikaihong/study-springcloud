package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.sys.Result;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServiceImpl implements PaymentService {

    @Override
    public Result payment(Long id) {
        return new Result().error("服务降级错误");
    }
}
