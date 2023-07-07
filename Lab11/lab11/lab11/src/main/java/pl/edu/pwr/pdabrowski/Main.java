package main.java.pl.edu.pwr.pdabrowski;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        StackParser stackParser = new StackParser();
        System.out.println(stackParser.getStack());
        System.out.println(stackParser.getStackCount());

    }
}