package org.example.service;

import org.example.model.ComplexNumber;
import org.example.model.IComplexNumber;

public interface ICalculatorService {
    ComplexNumber createComplexNumber();

    void add();
    void sub();
    void mul();
    void div();

}
