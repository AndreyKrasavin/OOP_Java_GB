package org.example.service;

import org.example.model.ComplexNumber;
import org.example.model.ComplexNumberCalculator;
import org.example.model.IComplexNumber;
import org.example.model.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorService implements ICalculatorService {
    private static ComplexNumberCalculator complexNumberCalculator;
    private ComplexNumber result = null;

    @Override
    public ComplexNumber createComplexNumber() {
        IComplexNumber number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Создание комплексного числа вида a + bi.");
        System.out.println("Введите a: ");
        double real = sc.nextDouble();
        System.out.println("Введите b: ");
        double imaginary = sc.nextDouble();
        return new ComplexNumber(real, imaginary);
    }

    public void initCalculator() {
        complexNumberCalculator = new ComplexNumberCalculator(createComplexNumber(), createComplexNumber());
    }

    @Override
    public void add() {
        double realPart = complexNumberCalculator.getNumber1().getReal() + complexNumberCalculator.getNumber2().getReal();
        double imaginaryPart = complexNumberCalculator.getNumber1().getImaginary() + complexNumberCalculator.getNumber2().getImaginary();
        result = new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public void sub() {
        double realPart = complexNumberCalculator.getNumber1().getReal() - complexNumberCalculator.getNumber2().getReal();
        double imaginaryPart = complexNumberCalculator.getNumber1().getImaginary() - complexNumberCalculator.getNumber2().getImaginary();
        result = new ComplexNumber(realPart, imaginaryPart);
    }

    /**
     * using formula for multiply complex numbers (a+bi)*(c+di) = (ac-bd) + (ad+bc)i
     */
    @Override
    public void mul() {
        double realPart = (complexNumberCalculator.getNumber1().getReal() * complexNumberCalculator.getNumber2().getReal()) - (complexNumberCalculator.getNumber1().getImaginary() * complexNumberCalculator.getNumber2().getImaginary());
        double imaginaryPart = (complexNumberCalculator.getNumber1().getReal() * complexNumberCalculator.getNumber2().getImaginary()) + (complexNumberCalculator.getNumber1().getImaginary() * complexNumberCalculator.getNumber2().getReal());
        result = new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public void div() {
        System.out.println("In progress...");
    }

    public void start() {
        initCalculator();
        Map<String, Operator> operatorMap = new HashMap<>();
        operatorMap.put("+", Operator.ADD);
        operatorMap.put("-", Operator.SUB);
        operatorMap.put("*", Operator.MUL);
        operatorMap.put("/", Operator.DIV);
        System.out.println("""
                Select operator:
                "+" - add
                "-" - subtract
                "*" - multiply
                "/" - divide
                """);
        Scanner scanner = new Scanner(System.in);
        String operator = scanner.next();
        if (operatorMap.containsKey(operator)) {
            switch (operatorMap.get(operator)){
                case ADD -> add();
                case SUB -> sub();
                case MUL -> mul();
                case DIV -> div();
            }
        } else System.out.println("You entered wrong operator.");
    }

    public ComplexNumber getResult() {
        return result;
    }
}
