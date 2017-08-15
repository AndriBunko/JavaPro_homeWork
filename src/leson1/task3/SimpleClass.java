package leson1.task3;

/**
 * Created by Andrew on 15.08.2017.
 */
public class SimpleClass {
    @Save
    private int i = 4;
    @Save
    private String s = "java";
    @Save
    private boolean b = true;
    private boolean t = false;

    public SimpleClass() {
    }

    public SimpleClass(int i, String s, boolean b) {
        this.i = i;
        this.s = s;
        this.b = b;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", b=" + b +
                '}';
    }
}
