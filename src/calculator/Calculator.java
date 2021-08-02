package calculator;

public class  Calculator {

    private static double a;
    private static double b;

    private static String operation;

    public static String getOperation() {
        return operation;
    }

    public static void setOperation(String operation) {
        Calculator.operation = operation;
    }

    public static double getA() {
        return a;
    }

    public static void setA(double a) {
        Calculator.a = a;
    }

    public static double getB() {
        return b;
    }

    public static void setB(double b) {
        Calculator.b = b;
    }

    static double addition(double a, double b) {
        return a + b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double difference(double a, double b) {
        return a - b;
    }

    static double division(double a, double b) {

        return a / b;
    }

    static double pow(double a, double b) {

        return Math.pow(a, b);
    }

    static double sqrt(double a) {

        return Math.sqrt(a);
    }

}