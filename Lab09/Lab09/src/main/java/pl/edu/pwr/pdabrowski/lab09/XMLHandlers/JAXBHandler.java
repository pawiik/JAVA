package pl.edu.pwr.pdabrowski.lab09.XMLHandlers;


import pl.edu.pwr.pdabrowski.lab09.model.*;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.jaxb.JAXBContextFactory;


public class JAXBHandler {

    public static List<KartaInformacyjna> resolveObjects(String s) throws JAXBException, FileNotFoundException {
        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(KartaInformacyjna.class);


//            JAXBElement<KartaInformacyjnaListWrapper> jaxbElement = (JAXBElement<KartaInformacyjnaListWrapper>) unmarshaller.unmarshal(new File("C:\\Users\\pawel\\Desktop\\aaa\\pawdab107_javata_2023\\Lab09\\Lab09\\src\\main\\resources\\pl\\edu\\pwr\\pdabrowski\\lab09\\pliczek.xml"));
//            KartaInformacyjnaListWrapper wrapper = jaxbElement.getValue();
//            List<KartaInformacyjna> listaObiektow = wrapper.getKartyInformacyjne();
            JAXBContext context = JAXBContextFactory.createContext(new Class[]{Bip.class}, null);
            Unmarshaller unmarshaller = context.createUnmarshaller();
//            Bip wrapper = (Bip) unmarshaller.unmarshal(new File("product.xml"));
            StringReader reader = new StringReader(s);

            Bip wrapper = (Bip) unmarshaller.unmarshal(reader);

            Data data = wrapper.getData();
            KartyInformacyjne kartyInformacyjne = data.getKartyInformacyjne();
            Items items = kartyInformacyjne.getItems();

            List<KartaInformacyjna> karty = items.getKartyInformacyjne();
            for (KartaInformacyjna kartaInformacyjna : karty) {
                // Wykonaj operacje na pojedynczej karcie informacyjnej
                System.out.println(kartaInformacyjna.toString());
            }
            return karty;
//            return (KartaInformacyjna) context.createUnmarshaller()
//                    .unmarshal(new FileReader("C:\\Users\\pawel\\Desktop\\aaa\\pawdab107_javata_2023\\Lab09\\Lab09\\src\\main\\resources\\pl\\edu\\pwr\\pdabrowski\\lab09\\pliczek.xml"));
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void marshal() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContextFactory.createContext(new Class[]{Items.class}, null);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        KartaInformacyjna karta1 = new KartaInformacyjna();
        karta1.setLink("https://bip.poznan.pl/bip/karty_informacyjne.html?co=print&noteid=OS_NT004422CE&typ_karty=A&api=xml");
        karta1.setId("OS_NT004422CE");
        karta1.setData("2023-05-26");
        karta1.setSkrotOrganizacja("WOS");
        karta1.setKomponentSrodowiska("decyzje środowiskowe");
        karta1.setTypKarty("A");
        karta1.setRodzajKarty("wnioski o wydanie decyzji");
        karta1.setNrWpisu("87944");
        karta1.setZnakSprawy("KSr-V.6220.1.135.2023");
        karta1.setDaneWnioskodawcy("Jakon Nowa 1 SOWIA 4, 62-080 TARNOWO PODGÓRNE");

        KartaInformacyjna karta2 = new KartaInformacyjna();
        karta2.setLink("https://bip.poznan.pl/bip/karty_informacyjne.html?co=print&noteid=OS_NT00441FDE&typ_karty=A&api=xml");
        karta2.setId("OS_NT00441FDE");
        karta2.setData("2023-05-23");
        karta2.setSkrotOrganizacja("WOS");
        karta2.setKomponentSrodowiska("decyzje środowiskowe");
        karta2.setTypKarty("A");
        karta2.setRodzajKarty("wnioski o wydanie decyzji");
        karta2.setNrWpisu("87908");
        karta2.setZnakSprawy("KSr-V.6220.1.134.2023");
        karta2.setDaneWnioskodawcy("EDICA Sp. z o.o. FORTECZNA 3, 61-362 POZNAŃ");

        Items list = new Items();
        List<KartaInformacyjna> aa = new ArrayList<>();
        aa.add(karta1);
        aa.add(karta2);
        list.setKartyInformacyjne(aa);
        marshaller.marshal(list, new File("product.xml"));
    }
    }


