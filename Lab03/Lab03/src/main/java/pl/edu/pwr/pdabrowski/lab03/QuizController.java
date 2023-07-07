package pl.edu.pwr.pdabrowski.lab03;

import com.fasterxml.jackson.databind.JsonNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.ChoiceFormat;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.ResourceBundle;

public class QuizController implements Initializable {
    public RadioButton english;
    public RadioButton polski;
    public ToggleGroup lang;
    public Text author;
    public Text cds;
    public TextField cdAndswer;
    public Button cdsButton;
    public Text answerText;
    public Button refreshButton;
    public TextField groupName;
    public TextField trackName;
    public TextField authInputField;
    public Text authAnswer;
    public Button authorConfirmButton;
    public Text authorRespone;
    public Text cdsResponse;
    public Text cdsResponse1;
    String language;
    String country;
    Locale locale;
    APIHandler apiHandler = new APIHandler();
    JsonNode song;
    JsonNode artist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.language = "en";
        this.country = "EN";
        this.locale = new Locale(this.language, this.country);
        refresh();
        refreshButtonClicked();
    }

    public void changeLanguage(MouseEvent event) {
        if(this.english.isSelected()){
            this.language = "en";
            this.country = "EN";
            this.locale = new Locale(this.language, this.country);
//            System.out.println("EN");
            refresh();
        }
        else if (this.polski.isSelected()){
            this.language = "pl";
            this.country = "PL";
            this.locale = new Locale(this.language, this.country);
//            System.out.println("PL");
            refresh();
        }

    }

    public void checkAuthor(MouseEvent event) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.Bundle", this.locale);
        if(!this.authInputField.getText().equals("")){
            //        System.out.println(this.song);
            String answer = this.authInputField.getText();
            String author = this.song.get("artist-credit").get(0).get("name").asText();
//        System.out.println(this.song.get("title").asText());
//        System.out.println(author);
            answer.replaceAll(" ", "");
            if(answer.toLowerCase().equals(author.toLowerCase())){
                String a = resourceBundle.getString("success") + author + resourceBundle.getString("success2") + this.trackName.getText().toString();
                this.authorRespone.setText(a);
            } else {
                String a = resourceBundle.getString("failure") + author;
                this.authorRespone.setText(a);
            }
        }
        else this.authorRespone.setText(resourceBundle.getString("empty"));
    }

    public void checkCD(MouseEvent event) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.Bundle", this.locale);

        if (!this.cdAndswer.getText().equals("")){

            int answer = Integer.parseInt(this.cdAndswer.getText());
            JsonNode artist = apiHandler.getArtist();
            this.groupName.setText(artist.get("cdstubs").get(0).get("artist").asText());
            int quantity = artist.get("cdstubs").size();

            System.out.println(quantity);
            double[] limits = {1, 2, 4 };
            ChoiceFormat form = new ChoiceFormat(limits, resourceBundle.getStringArray("howMuch"));
            ParsePosition status = new ParsePosition(0);
            if(answer == quantity){
                String message = resourceBundle.getString("success3") + " " + this.groupName.getText() + resourceBundle.getString("success4") + " " + quantity + form.format(quantity);
                this.cdsResponse.setText(message);
            }
            else {
                String message = resourceBundle.getString("failure") + quantity + form.format(quantity);
                this.cdsResponse.setText(message);
            }
        }else this.cdsResponse.setText(resourceBundle.getString("empty"));
    }

    public void refresh(){
//        System.out.println(this.apiHandler.randomSong());
        this.authorRespone.setText("");
        this.cdsResponse.setText("");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.Bundle", this.locale);
        this.answerText.setText(resourceBundle.getString("answer"));
        this.authAnswer.setText(resourceBundle.getString("answer"));
        this.author.setText(resourceBundle.getString("author"));
        this.cdsButton.setText(resourceBundle.getString("submit"));
        this.authorConfirmButton.setText(resourceBundle.getString("submit"));
        this.cds.setText(resourceBundle.getString("cds"));
        this.refreshButton.setText(resourceBundle.getString("refresh"));

    }

    public void refreshButtonClicked() {
        this.song = apiHandler.randomSong();
        this.artist = apiHandler.getArtist();
        this.groupName.setText(artist.get("cdstubs").get(0).get("artist").asText());
        this.trackName.setText(this.song.get("title").asText());
        this.authorRespone.setText("");
        this.cdsResponse.setText("");
    }
}