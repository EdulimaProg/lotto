package com.example.lotto.LottoRepo.Interface;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.lotto.LottoRepo.Interface.Lotto;
import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Services.HttpConnection;
import com.example.lotto.Utils.Constants;
import com.example.lotto.Utils.LotteryRangers;
import com.example.lotto.Utils.Utils;

public abstract class Lotto {
    public abstract void initConquest();

    public abstract void print();

    public abstract void printAllArray();

    public abstract void changePeriodOfConquest(int init, int end);
}
