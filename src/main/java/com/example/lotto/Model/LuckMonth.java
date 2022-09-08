package com.example.lotto.Model;

public class LuckMonth {
    String monthName;
    Integer quantity;
    public boolean lastConquest;
    public String percentage;

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isLastConquest() {
        return lastConquest;
    }

    public void setLastConquest(boolean lastConquest) {
        this.lastConquest = lastConquest;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

}
