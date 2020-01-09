package com.example.financialappnbp;

import com.example.financialappnbp.mathInterface.IArithmeticsAdd;

public class Math implements IArithmeticsAdd {

    @Override
    public double Addition(double A, double B) {
        return A + B;
    }
}
