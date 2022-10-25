package com.svalero.amazon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private float price;
    @Column
    private LocalDateTime creationDate;
    @Column
    private String observations;
    @Column
    private int quantity;

    private float getTotalPrice() {
        return price * quantity;
    }

    public float getTotalPriceWithoutDiscount() {
        return getTotalPrice();
    }

    public float getTotalPrice(float discount) {
        return getTotalPrice() - getTotalPrice() * discount;
    }

    public void algo() {
        int random = RandomUtils.nextInt(12, 15);
        String cadena = "hola que tal";
        String cadena10 = StringUtils.abbreviate(cadena, 10);
    }

}
