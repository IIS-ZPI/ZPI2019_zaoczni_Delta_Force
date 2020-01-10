package com.example.financialappnbp;
import com.example.financialappnbp.mathInterface.IArithmeticsDiff;
import com.example.financialappnbp.mathInterface.IArithmeticsDiv;
import com.example.financialappnbp.mathInterface.IArithmeticsAdd;
import com.example.financialappnbp.mathInterface.IArithmeticsMult;

public class Math implements IArithmeticsDiv, IArithmeticsAdd, IArithmeticsMult, IArithmeticsDiff {

    //Dzielenie
    @Override
    public double Division(double A, double B) {
        return A / B;
    }

    @Override
    public double Multiplication(double A, double B) {
        return A * B;
    }

    @Override
    public double Addition(double A, double B) {
        return A + B;
    }

    //Ten będzie do revertu
    @Override
    public double Difference(double A, double B) {
        return A-B;
    }
}
