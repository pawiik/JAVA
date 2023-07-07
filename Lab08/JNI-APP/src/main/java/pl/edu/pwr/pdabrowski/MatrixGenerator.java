package pl.edu.pwr.pdabrowski;

import java.util.Random;

public class MatrixGenerator {
    public static void main(String[] args) {
        int wysokosc = 4;   // Wysokość macierzy
        int szerokosc = 4;  // Szerokość macierzy

        int[][] macierz = generujMacierz(wysokosc, szerokosc);

        // Wyświetlanie wygenerowanej macierzy
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                System.out.print(macierz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generujMacierz(int wysokosc, int szerokosc) {
        int[][] macierz = new int[wysokosc][szerokosc];
        Random random = new Random();

        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                macierz[i][j] = random.nextInt(10);  // Losowa liczba całkowita z zakresu od 0 do 9
            }
        }

        return macierz;
    }
}