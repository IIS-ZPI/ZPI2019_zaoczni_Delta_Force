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
<<<<<<< HEAD
    @Override
=======

>>>>>>> 922e0b100b7c654540c0d4ed5e3dab4c0140ea32
    public double Addition(double A, double B) {
        return A + B;
    }

    /*Difference between values a and b*/
    @Override
    public double Difference(double A, double B) {
        return A-B;
    }
}
