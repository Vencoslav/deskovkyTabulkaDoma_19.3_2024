import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CustomTableModel extends AbstractTableModel {
    private List<Deskovka> seznamDeskovek;
    public CustomTableModel(List<Deskovka> seznamDeskovek){
        this.seznamDeskovek = seznamDeskovek;
    }

    public int getRowCount(){
        return seznamDeskovek.size();
    }

    public int getColumnCount(){
        return 3;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        Deskovka deskovka = seznamDeskovek.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return deskovka.getNazev();
            case 1:
                return deskovka.getVlastnictvi();
            case 2:
                return deskovka.getHodnoceni();
            default:
                return null;
        }
    }


    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Název";
            case 1:
                return "Vlastnictví";
            case 2:
                return "Hodnocení";
            default:
                return "";
        }
    }

}
