package com.example.lotto.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodasLoterias {
    @JsonProperty("MyArray")
    String myArray;

    public String getMyArray() {
        return this.myArray;
    }

    public void setMyArray(String myArray) {
        this.myArray = myArray;
    }
}
