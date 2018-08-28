package com.springboot.elasticsearch.service.impl;

import com.springboot.elasticsearch.entity.saleGoods.SaleGoodsElastic;
import com.springboot.elasticsearch.service.SaleGoodsService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleGoodsServiceImpl implements SaleGoodsService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void SaleGoodsList(){
        String appId = "10000";
        String key = "烤红薯";
        /*QueryBuilder appIdKey = QueryBuilders.termQuery("appId", appId);
        QueryBuilder queryBuilder  = QueryBuilders.queryStringQuery(key);
        QueryBuilder query = null;
        query = QueryBuilders.boolQuery().must(queryBuilder).must(appIdKey);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
        int count  = (int) elasticsearchTemplate.count(searchQuery,SaleGoodsElastic.class);*/




        QueryBuilder appIdKey = QueryBuilders.termQuery("appId", appId);
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(key);

        QueryBuilder query = QueryBuilders.boolQuery().must(queryBuilder).must(appIdKey);;

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(query).build();



    /*    Sort sort = new Sort(Sort.Direction.DESC,"_score");
        searchQuery.addSort(sort);*/

        System.out.println(searchQuery.getQuery()+">>>>>>>>>>");
        List<SaleGoodsElastic> list = elasticsearchTemplate.queryForList(searchQuery,SaleGoodsElastic.class);

    }
}
