package pl.edu.pwr.pdabrowski.lab02;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public List<String[]> readFile(String path) throws FileNotFoundException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
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
        return r;
    }
    public List<Measure> parseData(List<String[]> data){
        List<Measure> measures = new ArrayList<>();
        for (String[] a: data) {
            String[] tab = a[0].split(",");
            String hour = tab[0];
            String pressure = tab[1];
            float press = Float.parseFloat(pressure);
            String temperature = tab[2];
            float temp = Float.parseFloat(temperature);
            String humidity = tab[3];
            float hum = Float.parseFloat(humidity);
            Measure measure = new Measure(hour, press, temp, hum);
            measures.add(measure);
        }
        return measures;
    }
}