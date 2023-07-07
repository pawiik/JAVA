package pl.edu.pwr.pdabrowski;
//g++ -c -fPIC -I C:\Program Files\Java\jdk-17\include\jni.h -I C:\Program Files\Java\jdk-17\include\win32 Splot2DInCPP.cpp -o Splot2DInCPP.o -lc
import static pl.edu.pwr.pdabrowski.MatrixGenerator.generujMacierz;
import static pl.edu.pwr.pdabrowski.Splot2DInCPP.calculate;

public class Main {
////    "C:\\Users\\pawel\\Desktop\\python+native\\python-native\\CPP\\Dll1\\x64\\Debug\\Dll1.dll"

    public static void main(String[] args) {
        Splot2D convolution = new Splot2D();
        Splot2DInCPP cpp = new Splot2DInCPP();

        int[][] kernel = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] resultNative = calculate(kernel, matrix);


        int[][] resultNormal = convolution.obliczSplot(kernel, matrix);

        System.out.println("Wynik (Natywny):");
//        printMatrix(resultNative);

        System.out.println("Wynik (Normalny):");
        printMatrix(resultNormal);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}