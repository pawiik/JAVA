package pl.edu.pwr.pdabrowski.lab09.XMLHandlers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import pl.edu.pwr.pdabrowski.lab09.model.KartaInformacyjna;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class JAXPHandler {
    public static List<KartaInformacyjna> readData(String data) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());

            Document document = builder.parse(inputStream);

            Element root = document.getDocumentElement();

            String start = root.getElementsByTagName("start").item(0).getTextContent();
            String stop = root.getElementsByTagName("stop").item(0).getTextContent();
            String totalSize = root.getElementsByTagName("total_size").item(0).getTextContent();

            NodeList kartyInformacyjne = root.getElementsByTagName("karta_informacyjna");

            List<KartaInformacyjna> karty = new ArrayList<>();

            for (int i = 0; i < kartyInformacyjne.getLength(); i++) {
                KartaInformacyjna karta = new KartaInformacyjna();
                Element kartaInformacyjna = (Element) kartyInformacyjne.item(i);
                karta.setLink(kartaInformacyjna.getElementsByTagName("link").item(0).getTextContent());
                karta.setId(kartaInformacyjna.getElementsByTagName("id").item(0).getTextContent());
                karta.setData(kartaInformacyjna.getElementsByTagName("data").item(0).getTextContent());
                karta.setSkrotOrganizacja(kartaInformacyjna.getElementsByTagName("skrot_organizacja").item(0).getTextContent());
                karta.setKomponentSrodowiska(kartaInformacyjna.getElementsByTagName("komponent_srodowiska").item(0).getTextContent());
                karta.setTypKarty(kartaInformacyjna.getElementsByTagName("typ_karty").item(0).getTextContent());
                karta.setRodzajKarty(kartaInformacyjna.getElementsByTagName("rodzaj_karty").item(0).getTextContent());
                karta.setNrWpisu(kartaInformacyjna.getElementsByTagName("nr_wpisu").item(0).getTextContent());
                karta.setZnakSprawy(kartaInformacyjna.getElementsByTagName("znak_sprawy").item(0).getTextContent());
                karta.setDaneWnioskodawcy(kartaInformacyjna.getElementsByTagName("dane_wnioskodawcy").item(0).getTextContent());

                System.out.println(karta.toString());

                karty.add(karta);
            }


            return karty;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }}
