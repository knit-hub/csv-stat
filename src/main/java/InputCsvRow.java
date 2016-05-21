public class InputCsvRow {

    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private float L;

    //デフォルトコンストラクタを定義しないと怒られる
    public InputCsvRow() {}

    public InputCsvRow(float a, float b, float c, float d, float e, float f, float g, float h, float i, float j, float k, float l) {
        A = a;
        B = b;
        C = c;
        D = d;
        E = e;
        F = f;
        G = g;
        H = h;
        I = i;
        J = j;
        K = k;
        L = l;
    }

    //セッターを定義しないと怒られる
    public void setA(float a) {
        A = a;
    }

    public void setB(float b) {
        B = b;
    }

    public void setC(float c) {
        C = c;
    }

    public void setD(float d) {
        D = d;
    }

    public void setE(float e) {
        E = e;
    }

    public void setF(float f) {
        F = f;
    }

    public void setG(float g) {
        G = g;
    }

    public void setH(float h) {
        H = h;
    }

    public void setI(float i) {
        I = i;
    }

    public void setJ(float j) {
        J = j;
    }

    public void setK(float k) {
        K = k;
    }

    public void setL(float l) {
        L = l;
    }

    public float getA() {
        return A;
    }

    public float getB() {
        return B;
    }

    public float getC() {
        return C;
    }

    public float getD() {
        return D;
    }

    public float getE() {
        return E;
    }

    public float getF() {
        return F;
    }

    public float getG() {
        return G;
    }

    public float getH() {
        return H;
    }

    public float getI() {
        return I;
    }

    public float getJ() {
        return J;
    }

    public float getK() {
        return K;
    }

    public float getL() {
        return L;
    }

    @Override
    public String toString() {
        return A + "," + B + "," + C + "," + D + "," + E + "," + F + "," + G + "," + H + "," + I + ","  + J + ","  + K + ","  + L;
    }
}
