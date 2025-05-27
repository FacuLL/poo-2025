package Guias.Guia_4.Ej_5;

public abstract class TextModificator implements HTMLText {
    private final HTMLText content;

    public TextModificator(HTMLText content) {
        this.content = content;
    }

    protected HTMLText getContent() {
        return content;
    }

    @Override
    public String toString() {
        return source();
    }
}
