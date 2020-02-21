package com.example.financialappnbp;
import com.example.financialappnbp.mathInterface.IArithmeticsDiff;
import com.example.financialappnbp.mathInterface.IArithmeticsDiv;
import com.example.financialappnbp.mathInterface.IArithmeticsAdd;
import com.example.financialappnbp.mathInterface.IArithmeticsMult;

public class Math implements IArithmeticsDiv, IArithmeticsAdd, IArithmeticsMult, IArithmeticsDiff { //implements interface IArithmeticsDiv

    //Dzielenie
    @Override
    public double Division(double A, double B) {
        return A / B;
    }

    /*Try to multiply two values*/
    @Override
    public double Multiplication(double A, double B) {
        return A * B;
    }

    /*Addition of two values*/

    public double Addition(double A, double B) {
        return A + B;
    }

    /*Difference between values a and b*/
    @Override
    public double Difference(double A, double B) {
        return A-B;
    }
}
