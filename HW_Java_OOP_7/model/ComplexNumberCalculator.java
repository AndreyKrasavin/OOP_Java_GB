package org.example.model;

public class ComplexNumberCalculator extends Calculator {

    ComplexNumber number1;
    ComplexNumber number2;

    public ComplexNumberCalculator() {
    }

    public ComplexNumberCalculator(ComplexNumber number1, ComplexNumber number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public ComplexNumber getNumber1() {
        return number1;
    }

    public void setNumber1(ComplexNumber number1) {
        this.number1 = number1;
    }

    @Override
    public ComplexNumber getNumber2() {
        return number2;
    }

    public void setNumber2(ComplexNumber number2) {
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
