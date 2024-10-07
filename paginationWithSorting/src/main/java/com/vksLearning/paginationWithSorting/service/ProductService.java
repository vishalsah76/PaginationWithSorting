package com.vksLearning.paginationWithSorting.service;

import com.vksLearning.paginationWithSorting.dao.ProductRepository;
import com.vksLearning.paginationWithSorting.entities.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    //Note: Below task is a single time task to insert into db to test our scenario
   /*
   @PostConstruct
    public void initDB(){
        List<Product> products= IntStream.rangeClosed(1,200)
                .mapToObj(i->new Product("product"+i,new Random().nextInt(100),new Random().nextInt(5000)))
                .collect(Collectors.toList());
        productRepo.saveAll(products);

    }
    */
    public List<Product> findAllProduct(){
        return productRepo.findAll();
    }

    public List<Product> findAllSortedProducts(String field){
        return productRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Product> findProductWithPagination(int offset,int pageSize){
        Page<Product> products = productRepo.findAll(PageRequest.of(offset, pageSize));
        return products;
    }

    public Page<Product> findProductWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<Product> products = productRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
        return products;
    }


}
