package pl.dgorecki.shop_scrapper.enums;

import lombok.Getter;

@Getter
public enum UrlRegexp {
    SHOP("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,}" +
            "|(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,})") ,
    URL("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\." +
            "[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|" +
            "(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})"),
    PRICE("([0-9]+,[0-9]{2})|([0-9]+)");

    private final String value;

    UrlRegexp(String value) {
        this.value = value;
    }

}
