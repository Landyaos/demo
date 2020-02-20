package com.utopia.demo.nosql.elasticsearch.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

@Document(indexName = "movie")
public class EsMovie {
    @Id
    private Long id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String foreign_name;
    @Field(type = FieldType.Short)
    private Long length;
    @Field(type = FieldType.Text)
    private String language;
    @Field(type = FieldType.Keyword)
    private String area;
    @Field(type = FieldType.Date,format = DateFormat.date)
    private String release_date;
    @Field(type = FieldType.Float)
    private Float box_office;
    @Field(type = FieldType.Keyword)
    private String cover_url;
    @Field(type = FieldType.Float)
    private float rate;
    @Field(type = FieldType.Long)
    private long rate_num;
    @Field(type = FieldType.Keyword)
    private String weight;
    @Field(type = FieldType.Keyword)
    private String imdb_link;
    @Field(type = FieldType.Keyword)
    private String douban_link;
    @Field(type = FieldType.Keyword)
    private String rottenTomatoes_link;

    @Field(type = FieldType.Text)
    private List<String> director;

}
