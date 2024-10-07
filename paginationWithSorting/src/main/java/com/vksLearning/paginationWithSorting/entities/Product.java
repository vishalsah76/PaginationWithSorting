package com.vksLearning.paginationWithSorting.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@Table(name = "PRODUCT_TBL")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private long price;

    public Product(String name,int quantity,long price){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
    }
}
