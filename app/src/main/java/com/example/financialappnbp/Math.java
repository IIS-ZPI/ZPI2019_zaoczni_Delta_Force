package com.example.financialappnbp;
import com.example.financialappnbp.mathInterface.IArithmeticsDiff;

public class Math implements IArithmeticsDiff {


    @Override
    public Double difference(Double A, Double B) {
        return A/B;
    }
}
