//package com.utopia.demo.nosql.elasticsearch.pojo;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//
//import java.util.Date;
//
//@Document(indexName = "movie")
//public class EsMovie {
//    @Id
//    private Long id;
//    @Field
//    private String name;
//    @Field
//    private String foreign_name;
//    @Field
//    private String area;
//    @Field
//    private String language;
//    @Field
//    private Long length;
//    @Field
//    private String cover_url;
//    @Field
//    private Date release_date;
//    @Field
//    private double rate;
//    @Field
//    private long rate_num;
//    @Field
//    private String url_imdb;
//    @Field
//    private String url_douban;
//    @Field
//    private String id_douban;
//
//    @Override
//    public String toString() {
//        return "Movie{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", foreign_name='" + foreign_name + '\'' +
//                ", area='" + area + '\'' +
//                ", language='" + language + '\'' +
//                ", length=" + length +
//                ", cover_url='" + cover_url + '\'' +
//                ", release_date=" + release_date +
//                ", rate=" + rate +
//                ", rate_num=" + rate_num +
//                ", url_imdb='" + url_imdb + '\'' +
//                ", url_douban='" + url_douban + '\'' +
//                ", id_douban='" + id_douban + '\'' +
//                '}';
//    }
//
//    public EsMovie(Long id, String name, String foreign_name, String area, String language, long length, String cover_url, Date release_date, double rate, long rate_num, String url_imdb, String url_douban, String id_douban) {
//        this.id = id;
//        this.name = name;
//        this.foreign_name = foreign_name;
//        this.area = area;
//        this.language = language;
//        this.length = length;
//        this.cover_url = cover_url;
//        this.release_date = release_date;
//        this.rate = rate;
//        this.rate_num = rate_num;
//        this.url_imdb = url_imdb;
//        this.url_douban = url_douban;
//        this.id_douban = id_douban;
//    }
//
//    public Date getRelease_date() {
//        return release_date;
//    }
//
//    public void setRelease_date(Date release_date) {
//        this.release_date = release_date;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getForeign_name() {
//        return foreign_name;
//    }
//
//    public void setForeign_name(String foreign_name) {
//        this.foreign_name = foreign_name;
//    }
//
//    public String getArea() {
//        return area;
//    }
//
//    public void setArea(String area) {
//        this.area = area;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    public long getLength() {
//        return length;
//    }
//
//    public void setLength(long length) {
//        this.length = length;
//    }
//
//    public String getCover_url() {
//        return cover_url;
//    }
//
//    public void setCover_url(String cover_url) {
//        this.cover_url = cover_url;
//    }
//
//    public double getRate() {
//        return rate;
//    }
//
//    public void setRate(double rate) {
//        this.rate = rate;
//    }
//
//    public long getRate_num() {
//        return rate_num;
//    }
//
//    public void setRate_num(long rate_num) {
//        this.rate_num = rate_num;
//    }
//
//    public String getUrl_imdb() {
//        return url_imdb;
//    }
//
//    public void setUrl_imdb(String url_imdb) {
//        this.url_imdb = url_imdb;
//    }
//
//    public String getUrl_douban() {
//        return url_douban;
//    }
//
//    public void setUrl_douban(String url_douban) {
//        this.url_douban = url_douban;
//    }
//
//    public String getId_douban() {
//        return id_douban;
//    }
//
//    public void setId_douban(String id_douban) {
//        this.id_douban = id_douban;
//    }
//}
