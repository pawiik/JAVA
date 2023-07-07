package resources;

import java.util.ListResourceBundle;

public class Bundle extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"author", "Who is the author of  C"},
                {"submit", "Submit answer C?"},
                {"answer", "Answer :  C"},
                {"cds", "How much cd's  C"},
                {"refresh", "Refresh"},
                {"success", "You'r right, "},
                {"success2", "is author of "},
                {"success3", "You'r right, "},
                {"success4", "is author of "},
                {"failure", "You'r not right, correct answer is  "},
                {"empty", "You forgot to write answer"},
                {"howMuch", new String[]{ "cd","cds", "cds"}},
                {"cds2", "did make C"}};
    }
}
