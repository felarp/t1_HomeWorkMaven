package enums;


public enum Urls {

    MAINPAGE("https://the-internet.herokuapp.com/");


    private final String url;

    Urls(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
