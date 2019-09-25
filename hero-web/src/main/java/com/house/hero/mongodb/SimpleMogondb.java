package com.house.hero.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * mongodb 原生实现
 * @author jerry
 */
public class SimpleMogondb {

    public static void main(String[] args) {
        //连接the database address
        MongoClient mongoClient = new MongoClient("192.168.246.131");
        //得到要操作的数据库
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");
        //得到要操作的集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        //====>>> 插入数据
//        Map<String, Object> map = new HashMap<>();
//        map.put("content","MongoDB学习");
//        map.put("vision",8888);
//        map.put("_id",2);
//        Document document = new Document(map);
//        spit.insertOne(document);
        //<<<==== 插入数据

        //====>>> 获取数据
        //得到集合中所有的文档
        FindIterable<Document> documents = spit.find();

        //遍历结果
        for (Document document : documents) {
            //处理结果
            System.out.println(document.get("content"));
            System.out.println(document.get("vision"));
            System.out.println(document.get("_id"));
        }
        //<<<==== 获取数据

        mongoClient.close();
    }


}
