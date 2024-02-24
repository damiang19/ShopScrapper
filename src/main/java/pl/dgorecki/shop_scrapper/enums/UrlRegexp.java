package pl.dgorecki.shop_scrapper.enums;

public enum UrlRegexp {
    SHOP("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,}" +
            "|(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,})") ,
    URL("");

    private final String value;

    UrlRegexp(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
