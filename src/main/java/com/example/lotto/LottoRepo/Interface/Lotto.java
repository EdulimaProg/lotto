package com.example.lotto.LottoRepo.Interface;

import com.example.lotto.LottoRepo.Interface.Lotto;

public abstract class Lotto {
    public abstract void initConquest();

    public abstract void print();

    public abstract void printAllArray();

    public abstract void changePeriodOfConquest(int init, int end);
}
