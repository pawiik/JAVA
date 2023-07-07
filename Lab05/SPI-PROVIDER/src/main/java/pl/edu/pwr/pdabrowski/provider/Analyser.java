
package pl.edu.pwr.pdabrowski.provider;

import pl.edu.pwr.pdabrowski.api.AnalysisException;
import pl.edu.pwr.pdabrowski.api.AnalysisService;
import pl.edu.pwr.pdabrowski.api.DataSet;
public class Analyser implements AnalysisService {
    DataSet dataSet;
    double kappa;
    @Override
    public void setOptions(String[] strings) throws AnalysisException {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void submit(DataSet dataSet) throws AnalysisException {
        this.dataSet = dataSet;
    }

    @Override
    public DataSet retrieve(boolean b) throws AnalysisException {
        return null;
    }

    public double CalculateKappa(){
        String[][] data = this.dataSet.getData();
        int n = 4;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = Integer.parseInt(data[i][j]);
                sum += count;
            }
        }

        double p0 = 0;
        double pe = 0;
        for (int i = 0; i < n; i++) {
            p0 += Integer.parseInt(data[i][i]);
            double row = ((double) Integer.parseInt(data[i][0]) + Integer.parseInt(data[i][1])) / sum;
            double col = ((double) Integer.parseInt(data[0][i]) + Integer.parseInt(data[1][i])) / sum;
            pe += row * col;
        }
        p0 /= sum;

        double kappa = (p0 - pe) / (1 - pe);
        return kappa;
    }
}
