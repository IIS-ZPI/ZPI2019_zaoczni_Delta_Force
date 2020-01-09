package com.example.financialappnbp;

import com.example.financialappnbp.mathInterface.IArithmeticsMult;

public class Math implements IArithmeticsMult {

    @Override
    public double Multiplication(double A, double B) {
        return A * B;
    }
}
