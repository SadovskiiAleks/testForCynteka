package org.example;

public class Main {
    public static void main(String[] args) {
        Compare comparison = new Compare("A:\\ReadAndSearch\\input\\input.txt",
                "A:\\ReadAndSearch\\output\\output.txt");

        comparison.safeCompare();
        System.out.println("create!");
    }
}