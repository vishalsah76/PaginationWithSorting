package com.vksLearning.paginationWithSorting.dao;

import com.vksLearning.paginationWithSorting.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
