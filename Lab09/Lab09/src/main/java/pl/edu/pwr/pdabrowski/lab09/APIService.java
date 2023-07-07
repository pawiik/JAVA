package pl.edu.pwr.pdabrowski.lab09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIService {

    private final URL address;

    public APIService(String address) throws MalformedURLException {
        this.address = new URL(address);
    }

    public String sendGetRequest(){
        try {
            HttpURLConnection connection = (HttpURLConnection) this.address.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response: " + response.toString());

            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}
