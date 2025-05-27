package Guias.Guia_4.Ej_5;

public class ItalicText extends TextModificator {
    public ItalicText(HTMLText content) {
        super(content);
    }

    @Override
    public String source() {
        return "<i>"+super.getContent().source()+"</i>";
    }
}
