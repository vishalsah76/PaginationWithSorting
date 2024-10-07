package com.vksLearning.paginationWithSorting.controller;

import com.vksLearning.paginationWithSorting.dto.APIResponse;
import com.vksLearning.paginationWithSorting.entities.Product;
import com.vksLearning.paginationWithSorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public APIResponse<List<Product>> getAllProduct(){
        List<Product> allProduct = productService.findAllProduct();
        return new APIResponse<>(allProduct.size(),allProduct);
    }

    @GetMapping("/products/{field}")
    public APIResponse<List<Product>> getAllSortedProduct(@PathVariable String field){
        List<Product> allProduct = productService.findAllSortedProducts(field);
        return new APIResponse<>(allProduct.size(),allProduct);
    }

    @GetMapping("/products/{offset}/{pageSize}")
    public APIResponse<Page<Product>> getProductWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Product> productWithPagination = productService.findProductWithPagination(offset, pageSize);
        return new APIResponse<>(productWithPagination.getSize(),productWithPagination);
    }

    @GetMapping("/products/{offset}/{pageSize}/{field}")
    public APIResponse<Page<Product>> getProductWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field){
        Page<Product> productWithPagination = productService.findProductWithPaginationAndSorting(offset, pageSize,field);
        return new APIResponse<>(productWithPagination.getSize(),productWithPagination);
    }
}
