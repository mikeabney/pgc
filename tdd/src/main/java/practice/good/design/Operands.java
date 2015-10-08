package practice.good.design;

/**
 * Created by zacharycannon on 10/8/15.
 */
public enum Operands {
    ADD("+"), EQUALS("=");

    private String displayValue;

    private Operands(String displayValue) {
        this.displayValue = displayValue;
    }

    public String toString() {
        return this.displayValue;
    }
}
