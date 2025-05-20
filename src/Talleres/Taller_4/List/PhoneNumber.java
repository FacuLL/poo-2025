package Talleres.Taller_4.List;

public class PhoneNumber implements Comparable<PhoneNumber> {
    private final int areaCode;
    private final int prefix;
    private final int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "+" + areaCode + prefix + lineNumber;
    }

    @Override
    public int compareTo(PhoneNumber pn) {
        int result;
        if ((result = this.areaCode - pn.areaCode) != 0) return result;
        if ((result = this.prefix - pn.prefix) != 0) return result;
        if ((result = this.lineNumber - pn.lineNumber) != 0) return result;
        return result;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}

