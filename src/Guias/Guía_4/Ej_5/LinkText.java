package Guias.Guía_4.Ej_5;

public class LinkText extends TextModificator {
    private final String href;

    public LinkText(HTMLText content, String href) {
        super(content);
        this.href = href;
    }

    @Override
    public String source() {
        return "<a href=\"%s\">%s</a>".formatted(href, super.getContent().source());
    }
}
