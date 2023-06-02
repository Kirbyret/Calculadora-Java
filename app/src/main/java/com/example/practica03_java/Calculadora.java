package com.example.practica03_java;

public class Calculadora {

    public int num1;
    public int num2;

    public Calculadora(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int suma() {
        return num1 + num2;
    }

    public int resta() {
        return num1 - num2;
    }

    public int multiplicar() {
        return num1 * num2;
    }

    public int division() {
        int total = 0;
        if (num2 != 0) {
            total = num1 / num2;
        }
        return total;
    }
}
