package com.springboot.elasticsearch.service.impl;

import com.springboot.elasticsearch.entity.saleGoods.SaleGoodsElastic;
import com.springboot.elasticsearch.service.SaleGoodsService;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * termQuery : 完全匹配一个词语
 * queryStringQuery : 查询解析查询字符串(搜索范围是全部字段)
 * must : 跟AND 一样的
 * should : 跟OR 一样
 */
@Service
public class SaleGoodsServiceImpl implements SaleGoodsService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void SaleGoodsList(){
        String appId = "10000";
        String key = "000";
        /*
        QueryBuilder appIdKey = QueryBuilders.termQuery("appId", appId);
        QueryBuilder queryBuilder  = QueryBuilders.queryStringQuery(key);
        QueryBuilder query = null;
        query = QueryBuilders.boolQuery().must(queryBuilder).must(appIdKey);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
        int count  = (int) elasticsearchTemplate.count(searchQuery,SaleGoodsElastic.class);
        */

        QueryBuilder appIdKey = QueryBuilders.termQuery("appId", appId);
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(key);
        QueryBuilder query = QueryBuilders.boolQuery().must(queryBuilder).must(appIdKey);;
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(query).build();

        /**
         * 排序用法
        Sort sort = new Sort(Sort.Direction.DESC,"_score");
        searchQuery.addSort(sort);
        */
        // 调用ES的json语法
        System.out.println(searchQuery.getQuery());
        List<SaleGoodsElastic> list = elasticsearchTemplate.queryForList(searchQuery,SaleGoodsElastic.class);

        // 获取查询信息
        System.out.println(list.size());

    }

    /**
    * 定义分页查询
    * @author lints
    * @date 2018-12-17
    */
    @Override
    public void SaleGoodsPageList(){
        String appId = "10000";
        String key = "000";
        QueryBuilder appIdKey1 = QueryBuilders.termQuery("appId",appId);
        QueryBuilder esVal = QueryBuilders.queryStringQuery(key);
        QueryBuilder query1 = QueryBuilders.boolQuery().must(appIdKey1).must(esVal);
        SearchQuery searchQuery1 = new NativeSearchQueryBuilder().withQuery(query1).build();
        // 获取总数量
        long count = elasticsearchTemplate.count(searchQuery1);

        // 设置分页数量，默认分页为1,20
        int pageNo = 0;
        int pageSize = 20;
        /*if (page != null && page.getPageNo() >= 1) {
            pageNo = page.getPageNo() - 1;
        }
        if (page != null && page.getPageSize() > 0) {
            pageSize = page.getPageSize();
        }
        // 这里需要设置分页的总数量
        page.setToTal = total;
        */

        // 设置分页
        searchQuery1.setPageable(new PageRequest(pageNo,pageSize));

        // 设置排序
        /**
         *   Sort sort = new Sort(Sort.Direction.DESC,"_score");
         *   searchQuery1.addSort(sort);
         */

        // 定义查询
        Iterable<SaleGoodsElastic> list1 = elasticsearchTemplate.queryForPage(searchQuery1,SaleGoodsElastic.class);

    }


    @Override
    public void SaleGoodsTest(){
        // 测试查询语句
        String name = "棒棒零食";

        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("name",name);
        SearchQuery searchQuery1 = new NativeSearchQueryBuilder().withQuery(matchQuery).build();
        List<String> id = elasticsearchTemplate.queryForIds(searchQuery1);
        List<SaleGoodsElastic> ids = elasticsearchTemplate.queryForList(searchQuery1,SaleGoodsElastic.class);

        System.out.println("ids >> "+id);
       for(SaleGoodsElastic obj : ids){
           System.out.println("返回参数  >>>  "+obj.getName());
           System.out.println("返回参数  >>>  "+obj.getSaleGoodsId());
       }

       //QueryBuilders.termQuery()
       QueryBuilder b = QueryBuilders.matchAllQuery(); // 查找所有文档
       QueryBuilder b1 = QueryBuilders.matchQuery("name","张三"); // 模糊匹配指定字段
       QueryBuilder b2 = QueryBuilders.multiMatchQuery("张三","oldname","name"); // 单个值多个字段匹配
       QueryBuilder b3 = QueryBuilders.termQuery("name","张三"); // 完全匹配
       QueryBuilder b4 = QueryBuilders.termsQuery("name","张三","张三儿","张三三"); //  一次匹配多个值
       QueryBuilder b5 = QueryBuilders.wildcardQuery("name","?张三*"); // ? 表示单个匹配 * 表示多个匹配
       QueryBuilder b6 = QueryBuilders.matchPhraseQuery("name","棒棒零食"); // 短语匹配
       QueryBuilder b7 = QueryBuilders.matchPhrasePrefixQuery("name","棒"); // 短语前缀匹配
       PrefixQueryBuilder prefix = QueryBuilders.prefixQuery("name","棒棒"); // 指定字段前缀匹配
        DisMaxQueryBuilder disMax = QueryBuilders.disMaxQuery().add(b1).add(b2);    //  匹配更多的关键词排序在前面

        // 拼装连接(查询)条件  must 与AND 一样 should 与 OR 一样
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(b1).mustNot(b2).should(b3);





        WildcardQueryBuilder wildcardQueryBuilder = new WildcardQueryBuilder("name","?bangbangt");
    }
}
