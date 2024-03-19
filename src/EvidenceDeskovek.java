import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceDeskovek {
    private List<Deskovka> seznamDeskovek;
    private String nazevSouboru = "src/vstup"; // Use proper file path separator

    public List<Deskovka> getSeznam() {
        return seznamDeskovek;
    }

    public void nactiDeskovky() {
        seznamDeskovek = new ArrayList<>();
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(nazevSouboru)))) {
            while (sc.hasNextLine()) {
                String radek = sc.nextLine();
                String[] rozdelovac = radek.split(";");
                if (rozdelovac.length != 3) {
                    throw new RuntimeException("Špatný počet prvků na řádku.");
                }
                String nazev = rozdelovac[0].trim();
                boolean vlastnictvi = Boolean.parseBoolean(rozdelovac[1].trim());
                int hodnoceni = Integer.parseInt(rozdelovac[2].trim());
                Deskovka deskovka = new Deskovka(nazev, vlastnictvi, hodnoceni);
                seznamDeskovek.add(deskovka);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor " + nazevSouboru + " nebyl nalezen." + e.getLocalizedMessage());
        }
    }
}
