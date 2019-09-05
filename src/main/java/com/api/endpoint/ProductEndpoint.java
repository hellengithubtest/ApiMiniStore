package com.api.endpoint;

import com.mycompany.product.schema.GetProductResponse;
import com.api.repository.ProductRepository;
import com.mycompany.product.schema.GetProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://mycompany.com/product/schema";

    private ProductRepository productRepository;

    @Autowired
    public ProductEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProducts(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();

        response.getProducts().addAll(productRepository.findByNameContainingIgnoreCase(request.getName()));
        return response;
    }
}
