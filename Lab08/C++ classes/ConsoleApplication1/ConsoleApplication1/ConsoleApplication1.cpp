
#include <vector>
#include <iostream>


double newtonInterpolation(const std::vector<double>& x, const std::vector<double>& y, double xi) {
    int n = x.size();

    std::vector<std::vector<double>> differences(n, std::vector<double>(n));
    for (int i = 0; i < n; ++i)
        differences[i][0] = y[i];
    for (int j = 1; j < n; ++j) {
        for (int i = 0; i < n - j; ++i) {
            differences[i][j] = (differences[i + 1][j - 1] - differences[i][j - 1]) / (x[i + j] - x[i]);
        }
    }

    double result = 0;
    for (int i = 0; i < n; ++i) {
        double term = differences[0][i];
        for (int j = 0; j < i; ++j) {
            term *= (xi - x[j]);
        }
        result += term;
    }
    return result;
}

int main()
{
    std::vector<double> x = { 1, 2, 4, 6 };
    std::vector<double> y = { 2, 3, 1, 5 };
    double xi = 3;

    double interpolatedValue = newtonInterpolation(x, y, xi);
    std::cout << "Wartosc zinterpolowana: " << interpolatedValue << std::endl;

    return 0;
}

