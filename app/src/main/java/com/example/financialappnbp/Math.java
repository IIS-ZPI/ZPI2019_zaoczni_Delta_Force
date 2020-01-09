package com.example.financialappnbp;
import com.example.financialappnbp.mathInterface.IArithmeticsDiv;

public class Math implements IArithmeticsDiv {

    @Override
    public double Division(double A, double B) {

        return A/B;
    }
  
    @Override
    public double Multiplication(double A, double B) {
        return A * B;
}
