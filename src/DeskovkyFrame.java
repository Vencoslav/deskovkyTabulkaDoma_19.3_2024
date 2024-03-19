import javax.swing.*;
import java.awt.*;

public class DeskovkyFrame extends JFrame {
    private JPanel panelMain;
    private JTable table;
    private JScrollPane scrollPane;


    public DeskovkyFrame(){
        setSize(600,200);
        setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tabulka");

        EvidenceDeskovek evidenceDeskovek = new EvidenceDeskovek();
        evidenceDeskovek.nactiDeskovky();

        CustomTableModel tableModel = new CustomTableModel(evidenceDeskovek.getSeznam());
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        scrollPane = new JScrollPane(table);

        // Nastavení layoutu pro panelMain, pokud není nastaven již v GUI Designeru
        panelMain.setLayout(new BorderLayout());

        // Přidání JScrollPane s tabulkou do hlavního panelu
        panelMain.add(scrollPane, BorderLayout.CENTER);
    }
}
