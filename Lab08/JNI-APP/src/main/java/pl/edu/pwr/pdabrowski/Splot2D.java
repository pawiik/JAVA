package pl.edu.pwr.pdabrowski;

public class Splot2D {
    public  int[][] obliczSplot(int[][] jadro, int[][] macierz) {
        int jadroWys = jadro.length;
        int jadroSzer = jadro[0].length;
        int macierzWys = macierz.length;
        int macierzSzer = macierz[0].length;

        int[][] wynik = new int[macierzWys][macierzSzer];

        for (int i = 0; i < macierzWys; i++) {
            for (int j = 0; j < macierzSzer; j++) {
                int suma = 0;

                for (int m = 0; m < jadroWys; m++) {
                    for (int n = 0; n < jadroSzer; n++) {
                        int macierzWiersz = i - jadroWys / 2 + m;
                        int macierzKolumna = j - jadroSzer / 2 + n;

                        if (macierzWiersz >= 0 && macierzWiersz < macierzWys && macierzKolumna >= 0 && macierzKolumna < macierzSzer) {
                            suma += jadro[m][n] * macierz[macierzWiersz][macierzKolumna];
                        }
                    }
                }

                wynik[i][j] = suma;
            }
        }

        return wynik;
    }

}