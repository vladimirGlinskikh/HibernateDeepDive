package kz.zhelezyaka.fundamentalsCore.entities;

import jakarta.persistence.*;
import kz.zhelezyaka.fundamentalsCore.keys.ProductKey;

@Entity
@IdClass(ProductKey.class)
@Table(name = "product")
public class Product {

    @Id
    private String code;

    @Id
    private Long number;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
