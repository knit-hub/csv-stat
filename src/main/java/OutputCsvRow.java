public class OutputCsvRow {

    public int id;
    public float b;
    public float k;

    public OutputCsvRow() {
    }

    public OutputCsvRow(int id, float b, float k) {
        this.id = id;
        this.b = b;
        this.k = k;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setK(float k) {
        this.k = k;
    }

    public int getId() {
        return id;
    }

    public float getB() {
        return b;
    }

    public float getK() {
        return k;
    }

    @Override
    public String toString() {
        return b + "," + k;
    }
}
