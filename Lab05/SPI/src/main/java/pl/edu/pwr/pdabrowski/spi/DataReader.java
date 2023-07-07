package pl.edu.pwr.pdabrowski.spi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class DataReader {

    public String[] readHeader(String path){
        String delimiter = ",";
        String[] header = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            if (line != null) {
                header = line.split(delimiter);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return header;
    }

    public String[][] readFile(String path) throws FileNotFoundException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build(); // custom separator
        List<String[]> r;
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(path))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            r = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        String[][] result = new String[r.size()][];
        for (int i = 0; i < r.size(); i++) {
            result[i] = r.get(i);
        }

        return result;
    }
}
