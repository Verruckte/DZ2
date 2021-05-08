package com.example.calculatorexample;

import android.widget.TextView;

public class Calculator {
    private TextView mainScreen;
    private TextView memoryScreen;
    private String equation = "";

    public Calculator(TextView mainScreen, TextView memoryScreen) {
        this.mainScreen = mainScreen;
        this.memoryScreen = memoryScreen;
    }

    public void addToEquation(String key) {
        String input = mainScreen.getText().toString();
        String operation = String.format(" %s ", key);
        if (equation.length() > 3 && equation.endsWith(" ") && input.equals("")) {
            equation = equation.substring(0, equation.length() - 3);
        }
        equation = String.format("%s%s%s", equation, input, operation);
        memoryScreen.setText(equation);
        mainScreen.setText("");
    }

    public String calculate() {
        String[] equations = equation.split(" = ");
        String currentEquation = equations[equations.length - 1];
        String[] inputs = currentEquation.split(" ");
        double total = 0;
        String operator = "+";
        for (String value : inputs) {
            if (value.matches("([+\\-x/])")) {
                operator = value;
            } else if (!value.equals("=")) {
                switch (operator) {
                    case "+":
                        total += Double.parseDouble(value);
                        break;
                    case "-":
                        total -= Double.parseDouble(value);
                        break;
                    case "x":
                        total *= Double.parseDouble(value);
                        break;
                    case "/":
                        total /= Double.parseDouble(value);
                        break;
                }
            }
        }
        return String.valueOf(total);
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
