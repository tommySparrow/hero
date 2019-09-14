package com.house.hero.elasticFirst;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

public class ElasticSearchTest {

    TransportClient client = null;
    @Before
    public void init() throws Exception {
        //1.创建一个settings
        Settings settings = Settings.builder()
                .put("cluster.name","my-elasticsearch")
                .build();
        //2.创建一个客户端client对象
        client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9301));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9302));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9303));
    }

    @Test
    public void testSearchById(){

        //创建一个查询对象
        QueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds("1");
        search(queryBuilder);

    }
    @Test
    public void testSearchByTerm(){

        QueryBuilder queryBuilder = QueryBuilders.termQuery("tittle","打飞机");
        search(queryBuilder);
    }
    @Test
    public void testQueryString(){

        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery("房间的好处").defaultField("content");

        search(queryBuilder);
    }

    private void search(QueryBuilder queryBuilder) {
        //执行查询
        SearchResponse searchResponse = client.prepareSearch("index_hello")
                .setTypes("article")
                .setQuery(queryBuilder)
                //设置分页信息
                .setFrom(0)
                .setSize(5)
                .get();
        //获取查询结果
        SearchHits hits = searchResponse.getHits();
        //查询结果总记录数
        long totalHits = hits.getTotalHits();
        System.out.println(totalHits);
        //查询结果列表
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit searchHit : searchHits) {
            System.out.println(searchHit.getSourceAsString());
        }
        //关闭
        client.close();
    }

}
