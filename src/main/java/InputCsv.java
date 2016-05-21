import java.util.ArrayList;
import java.util.List;

public class InputCsv {

    private final List<InputCsvRow> csv;

    public InputCsv(List<InputCsvRow> csv) {
        this.csv = csv;
    }

    public List<Float> getColumB() {
        final List<Float> list = new ArrayList<Float>();
        for (InputCsvRow row: csv) {
            list.add(row.getB());
        }
        return list;
    }

    public List<Float> getColumK() {
        final List<Float> list = new ArrayList<Float>();
        for (InputCsvRow row: csv) {
            list.add(row.getK());
        }
        return list;
    }
}
