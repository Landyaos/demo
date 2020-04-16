package com.utopia.demo.dto;

import java.util.Arrays;

public class SearchQueryParam {

    private String content;
    private String limit;
    private String[] genrePick;
    private String[] areaPick;
    private String[] datePick;
    private Integer[] ratePick;
    private String tagPick;

    @Override
    public String toString() {
        return "SearchQuery{" +
                "content='" + content + '\'' +
                ", limit='" + limit + '\'' +
                ", genrePick=" + Arrays.toString(genrePick) +
                ", areaPick=" + Arrays.toString(areaPick) +
                ", datePick=" + Arrays.toString(datePick) +
                ", ratePick=" + Arrays.toString(ratePick) +
                ", tagPick='" + tagPick + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String[] getGenrePick() {
        return genrePick;
    }

    public void setGenrePick(String[] genrePick) {
        this.genrePick = genrePick;
    }

    public String[] getAreaPick() {
        return areaPick;
    }

    public void setAreaPick(String[] areaPick) {
        this.areaPick = areaPick;
    }

    public String[] getDatePick() {
        return datePick;
    }

    public void setDatePick(String[] datePick) {
        this.datePick = datePick;
    }

    public Integer[] getRatePick() {
        return ratePick;
    }

    public void setRatePick(Integer[] ratePick) {
        this.ratePick = ratePick;
    }

    public String getTagPick() {
        return tagPick;
    }

    public void setTagPick(String tagPick) {
        this.tagPick = tagPick;
    }
}
