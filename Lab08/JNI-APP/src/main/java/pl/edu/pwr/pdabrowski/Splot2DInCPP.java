package pl.edu.pwr.pdabrowski;

public class Splot2DInCPP {

    static {
        System.load("C:\\Users\\pawel\\Desktop\\python+native\\python-native\\CPP\\Dll1\\x64\\Debug\\Dll1.dll");
    }

    public native static int[][] calculate(int[][] jadro, int[][] macierz);

}
