package com.api.endpoint;

import com.api.product.schema.Product;
import com.api.service.ServiceProduct;
import com.api.product.schema.GetProductResponse;
import com.api.product.schema.GetProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://api.com/product/schema";

    private ServiceProduct serviceProduct;

    @Autowired
    public ProductEndpoint(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        List<Product> productList = new ArrayList<>();
        if(!request.getName().isEmpty()) {
            productList = serviceProduct.findByNameContainingIgnoreCase(request.getName());
        } else {
            productList = serviceProduct.findAll();
        }
        GetProductResponse response = new GetProductResponse();
        response.getProduct().addAll(productList);
        response.setCount(productList.size());
        return response;

    }
}
