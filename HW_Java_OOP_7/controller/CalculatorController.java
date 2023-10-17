package org.example.controller;

import org.example.service.CalculatorService;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();

    public void initProgram(){
        calculatorService.start();
    }

    public void getResult(){
        System.out.println(calculatorService.getResult());
    }
}
