package com.fallback;

import com.entity.Product;
import com.feignclients.ProductsClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ProductClientFallback implements ProductsClient {
    private Map<String,Object> map=new HashMap<>();
    @Override
    public Map<String, Object> showMsg() {
        map.put("ERROR","当前服务已经被降级,无法使用");
        return map;
    }

    @Override
    public Map<String, Object> findOne(String id2) {
        map.put("ERROR","当前服务已经被降级,无法使用");
        return map;
    }

    @Override
    public Map<String, Object> save(String name) {
        map.put("ERROR","当前服务已经被降级,无法使用");
        return map;
    }

    @Override
    public Map<String, Object> saveProduct(Product product) {
        map.put("ERROR","当前服务已经被降级,无法使用");
        return map;
    }

    @Override
    public Map<String, Object> saveProduct2(String productName) {
        map.put("ERROR","当前服务已经被降级,无法使用");
        return map;
    }

    @Override
    public Map<String, Object> testBreak(int id) {
        map.put("ERROR","当前服务已经被降级,无法使用");
        return map;
    }
}
