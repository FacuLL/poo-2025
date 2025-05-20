package Guias.Guía_4.Ej_5;

public class BoldText extends TextModificator {
    public BoldText(HTMLText content) {
        super(content);
    }

    @Override
    public String source() {
        return "<b>"+super.getContent().source()+"</b>";
    }
}
