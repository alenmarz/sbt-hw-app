package ru.sbt.pdrisapp.utils;

public class UriBuilder {
    private String uri;
    private boolean hasParams;

    public UriBuilder(String path) {
        uri = path;
        hasParams = false;
    }

    public UriBuilder queryParam(String name, String value) {
        uri += hasParams ? "&" : "?";
        uri += name + "=" + value;
        hasParams = true;

        return this;
    }

    public String toUriString() {
        return uri;
    }
}
