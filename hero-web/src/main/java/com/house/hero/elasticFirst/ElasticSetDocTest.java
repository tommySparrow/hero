package com.house.hero.elasticFirst;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.hero.common.bean.Article;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author jerry
 */
public class ElasticSetDocTest {

    public static void main(String[] args) throws Exception {
        //创建一个client对象
        TransportClient client = getTransportClient();
        //第一种添加doc的方式
//        firstTypeSetDoc(client);
        //第二种添加doc的方式

        for (int i = 13;i< 100;i++) {
            Article article = new Article();
            article.setId(i);
            article.setTittle("打飞机卡机付款方34567891012"+ i);
            article.setContent("房间的撒可富近段时间发快递34567891012" + i);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(article);
            client.prepareIndex("index_hello", "article", ""+ i).setSource(jsonStr, XContentType.JSON).get();
        }
        //3.关闭连接
        client.close();
    }

    private static void firstTypeSetDoc(TransportClient client) throws IOException {
        //1.创建doc信息
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("id",1L)
                .field("tittle","这是一个标题")
                .field("content","这是内容信息:放假放假看电视剧风刀霜剑范德萨了")
                .endObject();
        //2.使用client把doc设置到索引库
        client.prepareIndex("index_hello","article","1").setSource(builder).get();
    }

    private static TransportClient getTransportClient() throws UnknownHostException {
        //1.创建一个settings
        Settings settings = Settings.builder()
                .put("cluster.name","my-elasticsearch")
                .build();
        //2.创建一个客户端client对象
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9301));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9302));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9303));
        return client;
    }
}
