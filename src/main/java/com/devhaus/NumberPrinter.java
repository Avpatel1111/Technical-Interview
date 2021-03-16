package com.devhaus;

public class NumberPrinter {

    public static void main(String[] args) {
        new NumberPrinter().printNumbers(1, 105);
    }

    public void printNumbers(int start, int end) {
        if (start != 0 && end != 0 && start < end) {
            for (int i = start; i <= end; i++) {
                StringBuilder sb = new StringBuilder();

                if (i % 3 == 0) {
                    sb.append("Devhaus ");
                }
                if (i % 5 == 0) {
                    sb.append("Learning ");
                }
                if (i % 7 == 0) {
                    sb.append("Model ");
                }
                if (sb.length() != 0) {
                    System.out.println(sb.toString().trim());
                }
            }
        }
    }
}