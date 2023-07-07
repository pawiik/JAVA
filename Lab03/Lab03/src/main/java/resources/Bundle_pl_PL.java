package resources;

import java.util.ListResourceBundle;

public class Bundle_pl_PL extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"author", "Kto jest autorem utworu"},
                {"submit", "Sprawdź odpowiedź"},
                {"answer", "Odpowiedź"},
                {"cds", "Ile płyt wydał zespół"},
                {"refresh", "Odśwież"},
                {"success", "Zgadza się, "},
                {"success2", "jest autorem utworu"},
                {"success3", "Zgadza się, zespół"},
                {"success4", "wydał "},
                {"failure", "Nieprawidłowa odpowiedź, poprawna odpowiedź to "},
                {"empty", "Zapomniałeś wprowadzić odpowiedzi"},
                {"howMuch", new String[]{ "płyte","płyty", "płyt"}},
                {"cds2", "płyt"}};
    }
}