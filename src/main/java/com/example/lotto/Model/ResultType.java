package com.example.lotto.Model;

public class ResultType {
    Boolean acumulatedConquest;
    Boolean getPair;
    Boolean getPrimo;
    Integer pairQuantity;
    Integer primoQuantity;
    Boolean repeateNumbers;

    public ResultType(Boolean acumulatedConquest, Boolean getPair, Boolean getPrimo, Integer pairQuantity,
            Integer primoQuantity, Boolean repeateNumbers) {
        this.acumulatedConquest = acumulatedConquest;

        if (getPair == null) {
            this.getPair = false;
        } else {
            this.getPair = getPair;
        }

        if (getPair == null) {
            this.getPrimo = false;
        } else {
            this.getPrimo = getPrimo;
        }

        this.pairQuantity = pairQuantity;
        this.primoQuantity = primoQuantity;
        this.repeateNumbers = repeateNumbers;
    }

    public Boolean getAcumulatedConquest() {
        return acumulatedConquest;
    }

    public void setAcumulatedConquest(Boolean acumulatedConquest) {
        this.acumulatedConquest = acumulatedConquest;
    }

    public Boolean getGetPair() {
        if (getPair == null) {
            return false;
        }
        return getPair;
    }

    public void setGetPair(Boolean getPair) {
        this.getPair = getPair;
    }

    public Integer getPairQuantity() {
        return pairQuantity;
    }

    public void setPairQuantity(Integer pairQuantity) {
        this.pairQuantity = pairQuantity;
    }

    public Boolean getGetPrimo() {
        return getPrimo;
    }

    public void setGetPrimo(Boolean getPrimo) {
        this.getPrimo = getPrimo;
    }

    public Integer getPrimoQuantity() {
        if (getPrimo == null) {
            return 0;
        }
        return primoQuantity;
    }

    public void setPrimoQuantity(Integer primoQuantity) {
        this.primoQuantity = primoQuantity;
    }

    public Boolean getRepeateNumbers() {
        return repeateNumbers;
    }

    public void setRepeateNumbers(Boolean repeateNumbers) {
        this.repeateNumbers = repeateNumbers;
    }
}
