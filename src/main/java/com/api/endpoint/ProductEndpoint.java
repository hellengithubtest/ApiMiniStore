package com.api.endpoint;

import com.api.config.service.ServiceProduct;
import com.api.product.schema.GetProductResponse;
import com.api.repository.ProductRepository;
import com.api.product.schema.GetProductRequest;
import com.api.product.schema.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
        System.out.println("Get product response");
        System.out.println("Name from request" + request.getName());
        GetProductResponse response = new GetProductResponse();
        List<Product> list = serviceProduct.findByNameContainingIgnoreCase(request.getName());
        System.out.println("list from response" + list);
        response.getProduct().addAll(serviceProduct.findByNameContainingIgnoreCase(request.getName()));
        return response;
    }
}
