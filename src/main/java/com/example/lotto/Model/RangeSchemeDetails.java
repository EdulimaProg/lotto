package com.example.lotto.Model;

public class RangeSchemeDetails {
    Integer name;
    Integer quantity;

    public RangeSchemeDetails(Integer name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Integer getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
