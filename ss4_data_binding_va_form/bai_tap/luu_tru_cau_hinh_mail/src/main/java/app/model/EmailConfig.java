package app.model;

import java.util.List;

public class EmailConfig {
    private String language;
    private Integer pageSize;
    private boolean spamFilter;
    private String name;
    private String signature;

    public EmailConfig() {
    }

    public EmailConfig(String language, Integer pageSize, boolean spamFilter, String name, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.name = name;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Language: " + language + " || pageSize: " + pageSize + " || spamFilter: " + spamFilter + " || Name: " + name + " || Signature: " + signature;
    }
}
