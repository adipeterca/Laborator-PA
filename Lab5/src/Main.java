import CatalogUtilities.*;
import Items.*;
import Exceptions.CustomException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            // We create a new Catalog object
            Catalog c = new Catalog("F:\\Facultate\\PROIECTE JAVA [PA]\\Laborator-PA\\Lab5\\catalog.txt");

            // We create two different items
            Song s = new Song("F:\\Facultate\\PROIECTE JAVA [PA]\\Laborator-PA\\Lab5\\song.mp3", "Song free", "Indie");
            Image i = new Image("F:\\Facultate\\PROIECTE JAVA [PA]\\Laborator-PA\\Lab5\\bird.jpg", "Birds",false);

            // We add them to the Catalog
            CatalogUtil.add(c, s);
            CatalogUtil.add(c, i);

            // We open the image
            CatalogUtil.play(i);

            // We list the contents
            CatalogUtil.list(c);

            // We save and load the Catalog in a new variable
            CatalogUtil.save(c);
            Catalog c2 = CatalogUtil.load("F:\\Facultate\\PROIECTE JAVA [PA]\\Laborator-PA\\Lab5\\catalog.txt");

            // Is the Catalog object (which was loaded from memory) null?
            assert c2 != null;
            CatalogUtil.list(c2);
        }
        catch (CustomException exp) {
            System.out.println("Main exception : " + exp.getMessage());
        }
        catch (IOException exp) {
            System.out.println("IO exception : " + exp.getMessage());
        }

    }

}
