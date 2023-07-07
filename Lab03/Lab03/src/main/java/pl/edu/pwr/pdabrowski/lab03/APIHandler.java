package pl.edu.pwr.pdabrowski.lab03;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class APIHandler {

    public JsonNode randomSong(){
        JsonNode response = getInfo("https://musicbrainz.org/ws/2/release?query=date:%5B1964+TO+2023%5D&limit=100&fmt=json");
        List<JsonNode> songs = new ArrayList<>();
        for (int i = 0; i < 100; i++){
//            System.out.println(response.get("releases").get(i));
            songs.add(response.get("releases").get(i));
        }
        Random r = new Random();
        int random = r.nextInt(100);
        return songs.get(random);
//        "https://musicbrainz.org/ws/2/release?query=date:%5B1964+TO+1978%5D+AND+country:br&limit=25&fmt=json"
    }

    public JsonNode getArtist(){
        JsonNode song = randomSong();
        System.out.println(song);
        String author = song.get("artist-credit").get(0).get("name").asText();
        String url = "https://musicbrainz.org/ws/2/cdstub/?query=artist:" + author + "&fmt=json";
        JsonNode response = getInfo("https://musicbrainz.org/ws/2/cdstub/?query=artist:Disturbed&fmt=json");
        return response;
    }

    public JsonNode getInfo(String surl ){
        try {
            URL url = new URL(surl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Connection", "keep-alive");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

//            System.out.println(content);

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = objectMapper.readTree(content.toString());
//            System.out.println(jsonNode);

            return jsonNode;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
