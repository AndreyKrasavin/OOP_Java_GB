package org.example.model;

public abstract class Calculator implements ICalculator {
    private IComplexNumber number1;
    private IComplexNumber number2;


    public Calculator() {
    }

    public Calculator(IComplexNumber number1, IComplexNumber number2) {
        this.number1 = number1;
        this.number2 = number2;

    }

    public IComplexNumber getNumber1() {
        return number1;
    }

    public void setNumber1(IComplexNumber number1) {
        this.number1 = number1;
    }

    public IComplexNumber getNumber2() {
        return number2;
    }

    public void setNumber2(IComplexNumber number2) {
        this.number2 = number2;
    }


    @Override
    public String toString() {
        return "number1=" + number1 +
                ", number2=" + number2;
    }
}
