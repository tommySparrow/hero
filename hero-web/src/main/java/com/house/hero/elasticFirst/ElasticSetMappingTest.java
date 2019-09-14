package com.house.hero.elasticFirst;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

/**
 * @author jerry
 */
public class ElasticSetMappingTest {

    public static void main(String[] args) throws Exception {

        //1.创建一个settings
        Settings settings = Settings.builder()
                .put("cluster.name","my-elasticsearch")
                .build();
        //2.创建一个客户端client对象
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9301));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9302));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9303));
        //3.创建mapping信息
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                    .startObject("article")
                        .startObject("properties")
                            .startObject("id")
                                .field("type","long")
                                .field("store",true)
                            .endObject()
                            .startObject("tittle")
                            .field("type","text")
                            .field("store",true)
                            .field("analyzer","ik_smart")
                            .endObject()
                            .startObject("content")
                            .field("type","text")
                            .field("store",true)
                            .field("analyzer","ik_smart")
                            .endObject()
                        .endObject()
                    .endObject()
                .endObject();
        //4.使用client把mapping设置到索引库
        client.admin().indices()
                .preparePutMapping("index_hello")
                .setType("article")
                .setSource(builder)
                .get();

        //5.关闭连接
        client.close();
    }
}
