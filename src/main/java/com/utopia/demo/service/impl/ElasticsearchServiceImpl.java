package com.utopia.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.utopia.demo.service.ElasticsearchService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {

    @Qualifier("client")
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    //自定义组合查询
    //BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
    //TermQueryBuilder termQuery = QueryBuilders.termQuery(STATUS, STATUS);
    //MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("coutent",coutent)
    //        .fuzziness(Fuzziness.AUTO); //模糊匹配
    //boolQueryBuilder.must(termQuery).must(queryBuilder);
    //sourceBuilder.query(boolQueryBuilder);
    //sourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC)); //根据自己的需求排序

    //List<User> list = new ArrayList<>();
    //SearchHits hits = searchResponse.getHits();
    //hits.forEach(item -> list.add(JSON.parseObject(item.getSourceAsString(), User.class)));
    //return new PageImpl<>(list, pageable, hits.getTotalHits().value);

    private <T> Map<String, Object> commonSearch(String index,SearchSourceBuilder searchSourceBuilder, Class<T> tClass) {
        Map<String, Object> map = new HashMap<>();
        //创建检索请求
        SearchRequest searchRequest = new SearchRequest(index);
        //传入构建进行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            map.put("status", 500);
            map.put("errMsg", e.getMessage());
            return map;
        }
        //处理结果
        RestStatus restStatus = searchResponse.status();
        if (restStatus != RestStatus.OK) {
            map.put("status", 400);
            map.put("errMsg", "Elasticsearch searchResponse failed");
        } else {
            map.put("status", 200);
            List<T> resultList = new ArrayList<>();
            SearchHits hits = searchResponse.getHits();
            hits.forEach(item -> resultList.add(JSON.parseObject(item.getSourceAsString(), tClass)));
            map.put("resultList", resultList);
            //return new PageImpl<>(list, pageable, hits.getTotalHits().value);
        }
        return map;
    }

    @Override
    public <T> Map<String, Object> findAll(String index, Pageable pageable, Class<T> tClass) {
        //创建搜索构建者
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置构建搜索属性
        if (pageable != null) {
            sourceBuilder.from(pageable.getPageNumber() * pageable.getPageSize()); // 需要注意这里是从多少条开始
            sourceBuilder.size(pageable.getPageSize()); //共返回多少条数据
        }
        sourceBuilder.query(QueryBuilders.matchAllQuery());

        return commonSearch(index, sourceBuilder, tClass);
    }

    @Override
    public <T> Map<String, Object> findById(String index, Long id, Pageable pageable, Class<T> tClass) {
        //创建搜索构建者
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置构建搜索属性
        if (pageable != null) {
            sourceBuilder.from(pageable.getPageNumber() * pageable.getPageSize()); // 需要注意这里是从多少条开始
            sourceBuilder.size(pageable.getPageSize()); //共返回多少条数据
        }
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("id", id);
        boolQueryBuilder.must(termQueryBuilder);
        sourceBuilder.query(boolQueryBuilder);
        return commonSearch(index, sourceBuilder, tClass);
    }

    @Override
    public <T> Map<String, Object> findByQuery(String index, Map query, Pageable pageable, Class<T> tClass) {

        return null;
    }

    @Override
    public <T> Map<String, Object> findCommentReviewByMovieId(String index, Long movieId, Pageable pageable, Class<T> tClass) {
        //创建搜索构建者
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置构建搜索属性
        if (pageable != null) {
            sourceBuilder.from(pageable.getPageNumber() * pageable.getPageSize()); // 需要注意这里是从多少条开始
            sourceBuilder.size(pageable.getPageSize()); //共返回多少条数据
        }
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("movie.id", movieId);
        boolQueryBuilder.must(termQueryBuilder);
        sourceBuilder.query(boolQueryBuilder);

        return commonSearch(index, sourceBuilder, tClass);
    }
}
