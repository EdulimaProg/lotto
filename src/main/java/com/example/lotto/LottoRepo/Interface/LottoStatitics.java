package com.example.lotto.LottoRepo.Interface;

public abstract class LottoStatitics {
    public abstract void initArrays();

    public abstract void getResultOfLastConquest();

    public abstract void getMostAwardedNumberForSpecificPeriod(Integer start, Integer end);

    public abstract void getPrimeNumbersOfLastConquest();

    public abstract void getPairNumbersOfLastconquest();

    public abstract void getMostAwardNumbersInLastConquest();

    public abstract void confenceMyBetWithLastResults();
}
