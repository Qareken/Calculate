package Enumeration;

public enum MathematicalSymbol {
    DIVIDE("/"),
    SUBSTRING("-"),
    MULTIPLE("*"),
    PLUS("+");

    private String mathematic;

    private MathematicalSymbol(String mathematic) {
        this.mathematic = mathematic;
    }

    public String getMathematic() {
        return this.mathematic;
    }
}
