package Mainpack;

import javax.swing.*;
import java.util.ArrayList;

public class InterfaceC {
    public static void main(String[] args) {

        String errorTitle = "Ошибка";
        String resultTitle = "Результат";
        String end = "end";

        ArrayList<String> errorList = new ArrayList<>();
        errorList.add("Нельзя делитьна 0!");
        errorList.add("Вы не ввели число!");
        errorList.add(" - ЯВЛЯЕТСЯ ОТРИЦАТЕЛЬНЫМ!");
        errorList.add("Вы ввели неверный оператор или оставили строку пустой!");
        errorList.add("");

        ArrayList<String> massages = new ArrayList<>();
        massages.add("Завершение программы");
        massages.add("NEW Iteration");
        massages.add("Введите число А");
        massages.add("Введите число Б");

        System.out.println("НАДА ПАЩЫТАЦЬ!");

        while (true) {
            while (true) {

                String digitA = JOptionPane.showInputDialog(massages.get(2));

                if (isDigit(digitA)) {
                    Calculator.setA(Double.parseDouble(digitA));
                    System.out.println("A = " + Calculator.getA());
                    break;
                } else if ((digitA != null) && digitA.equals(end)) {
                    System.out.println(massages.get(0));
                    System.exit(0);
                } else {
                    System.out.println(errorList.get(1));
                    JOptionPane.showMessageDialog(null, errorList.get(1), errorTitle, JOptionPane.INFORMATION_MESSAGE);
                }
            }

            while (true) {

                String op = JOptionPane.showInputDialog("Введите операцию +, -, *, /, pow - Возведение в степень, sqrt - извлечение квадратного корня корня   ");

                if ((op != null) && (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("pow") || op.equals("sqrt"))) {
                    Calculator.setOperation(op);
                    break;// Закрывает while с назначением оператора
                } else if ((op != null) && op.equals(end)) {
                    System.out.println(massages.get(0));
                    System.exit(0);// Завершает программу
                } else {
                    System.out.println(errorList.get(3)); //ошибка, не оператор, отправляет на повтор в While
                    JOptionPane.showMessageDialog(null, errorList.get(3), errorTitle, JOptionPane.INFORMATION_MESSAGE);
                }
            }

            boolean division = (Calculator.getOperation()).equals("/");
            boolean sqrt = (Calculator.getOperation()).equals("sqrt");

            if (!sqrt) {
                while (true) {

                    String digitB = JOptionPane.showInputDialog(massages.get(3));

                    if (isDigit(digitB)) {
                        Calculator.setB(Double.parseDouble(digitB));
                        System.out.println("Б = " + Calculator.getB());
                        break;
                    } else if ((digitB != null) && digitB.equals(end)) {
                        System.out.println(massages.get(0));
                        System.exit(0);
                    } else {
                        System.out.println(errorList.get(1));
                        JOptionPane.showMessageDialog(null, errorList.get(1), errorTitle, JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

            double a = Calculator.getA();
            double b = Calculator.getB();

            String resultPlus = "\nСумма чисел " + a + " и " + b + " равна " + Calculator.addition(a, b);
            String resultMultiply = "\nПроизведение чисел " + a + " и " + b + " равно " + Calculator.multiply(a, b);
            String resultDifference = "\nРазность чисел " + a + " и " + b + " равна " + Calculator.difference(a, b);
            String resultDivision = "\nЧастное чисел " + a + " и " + b + " равно " + Calculator.division(a, b);
            String resultPow = "\nЧисло " + a + " в степени " + b + " = " + Calculator.pow(a, b);
            String resultSqrt = "\nКорень из " + a + " равен " + Calculator.sqrt(a);


            switch (Calculator.getOperation()) {
                case "+" -> {
                    System.out.println(resultPlus);
                    JOptionPane.showMessageDialog(null, resultPlus, resultTitle, JOptionPane.INFORMATION_MESSAGE);
                }
                case "*" -> {
                    System.out.println(resultMultiply);
                    JOptionPane.showMessageDialog(null, resultMultiply, resultTitle, JOptionPane.INFORMATION_MESSAGE);
                }
                case "-" -> {
                    System.out.println(resultDifference);
                    JOptionPane.showMessageDialog(null, resultDifference, resultTitle, JOptionPane.INFORMATION_MESSAGE);
                }
                case "pow" -> {
                    System.out.println(resultPow);
                    JOptionPane.showMessageDialog(null, resultPow, resultTitle, JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if (division && b != 0) {
                System.out.println(resultDivision);
                JOptionPane.showMessageDialog(null, resultDivision, resultTitle, JOptionPane.INFORMATION_MESSAGE);
            } else if ((!sqrt) && b == 0) {
                System.out.println(errorList.get(0));
                JOptionPane.showMessageDialog(null, errorList.get(0), errorTitle, JOptionPane.INFORMATION_MESSAGE);
            }

            if (sqrt && a >= 0) {
                JOptionPane.showMessageDialog(null, resultSqrt, resultTitle, JOptionPane.INFORMATION_MESSAGE);
                System.out.println(resultSqrt);
            } else if (a < 0) {
                System.out.println(a + errorList.get(2));
                JOptionPane.showMessageDialog(null, a + errorList.get(2), errorTitle, JOptionPane.INFORMATION_MESSAGE);
            }

            System.out.println("\nNEW Iteration");

        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}