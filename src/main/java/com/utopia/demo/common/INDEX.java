package com.utopia.demo.common;

public enum  INDEX {

    MOVIE("movie"),
    COMMENT("comment"),
    REVIEW("review")
    ;
    private String index;

    private INDEX(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
