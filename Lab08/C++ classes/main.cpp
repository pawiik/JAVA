#include <iostream>
#include <vector>

std::vector<std::vector<int>> obliczSplot(const std::vector<std::vector<int>>& jadro, const std::vector<std::vector<int>>& macierz) {
    int jadroWys = jadro.size();
    int jadroSzer = jadro[0].size();
    int macierzWys = macierz.size();
    int macierzSzer = macierz[0].size();
    
    std::vector<std::vector<int>> wynik(macierzWys, std::vector<int>(macierzSzer, 0));
    
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

int main() {
    std::vector<std::vector<int>> jadro = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    std::vector<std::vector<int>> macierz = {{2, 2, 2, 2}, {2, 3, 3, 2}, {2, 3, 3, 2}, {2, 2, 2, 2}};
    
    std::vector<std::vector<int>> wynik = obliczSplot(jadro, macierz);
    
    // Wyświetlanie wyniku
    for (int i = 0; i < wynik.size(); i++) {
        for (int j = 0; j < wynik[0].size(); j++) {
            std::cout << wynik[i][j] << " ";
        }
        std::cout << std::endl;
    }
    
    return 0;
}
Podobnie jak w przypadku implementacji w języku Java, powyższy kod zawiera funkcję obliczSplot, która przyjmuje dwie tablice dwuwymiarowe jako argumenty i zwraca wynikową macierz. Funkcja iteruje przez elementy macierzy wynikowej i oblicza wartość splotu na podstawie jądra splotu i fragmentu macierzy przetwarzanej. Następnie w funkcji main tworzę przykładowe macierze jadro i macierz





User
Dodaj proszę komentarze do kodu napisanego w javie z opisem co robi dany fragment kodu
ChatGPT
Oczywiście! Oto kod w języku Java z dodanymi komentarzami, które opisują, co robi dany fragment kodu:

java
Copy code
public class Splot2D {
    public static int[][] obliczSplot(int[][] jadro, int[][] macierz) {
        int jadroWys = jadro.length;                     // Wysokość jądra splotu
        int jadroSzer = jadro[0].length;                 // Szerokość jądra splotu
        int macierzWys = macierz.length;                 // Wysokość macierzy przetwarzanej
        int macierzSzer = macierz[0].length;             // Szerokość macierzy przetwarzanej
        
        int[][] wynik = new int[macierzWys][macierzSzer]; // Macierz wynikowa
        
        for (int i = 0; i < macierzWys; i++) {
            for (int j = 0; j < macierzSzer; j++) {
                int suma = 0;                            // Zmienna przechowująca sumę
                
                for (int m = 0; m < jadroWys; m++) {
                    for (int n = 0; n < jadroSzer; n++) {
                        int macierzWiersz = i - jadroWys / 2 + m;     // Wiersz macierzy przetwarzanej dla aktualnego elementu jądra splotu
                        int macierzKolumna = j - jadroSzer / 2 + n;   // Kolumna macierzy przetwarzanej dla aktualnego elementu jądra splotu
                        
                        if (macierzWiersz >= 0 && macierzWiersz < macierzWys && macierzKolumna >= 0 && macierzKolumna < macierzSzer) {
                            suma += jadro[m][n] * macierz[macierzWiersz][macierzKolumna];  // Obliczenie sumy na podstawie iloczynu elementów jądra i macierzy przetwarzanej
                        }
                    }
                }
                
                wynik[i][j] = suma;                    // Przypisanie obliczonej sumy do odpowiedniego elementu macierzy wynikowej
            }
        }
        
        return wynik;                                 // Zwrócenie macierzy wynikowej
    }
}
Dodane komentarze opisują działanie poszczególnych fragmentów kodu, w tym:

Obliczanie wymiarów jądra splotu i macierzy przetwarzanej,
Inicjalizacja macierzy wynikowej,
Iteracja przez elementy macierzy wynikowej i obliczanie sumy na podstawie jądra splotu i fragmentu macierzy przetwarzanej,
Sprawdzanie warunków granicznych w przypadku wystawania jądra splotu poza macierz przetwarzaną,
Przypisywanie obliczonej sumy do odpowiedniego elementu macierzy wynikowej,
Zwracanie macierzy wynikowej.
Te komentarze mają na celu lepsze zrozumienie kodu i działania funkcji obliczającej splot.






