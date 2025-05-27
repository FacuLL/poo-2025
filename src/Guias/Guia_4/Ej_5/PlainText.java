package Guias.Guia_4.Ej_5;

public class PlainText implements HTMLText {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String source() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
