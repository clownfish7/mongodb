package com.clownfish7;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yzy
 * @classname MongoDemon2
 * @description TODO
 * @create 2019-06-27 16:04
 */
@SuppressWarnings("all")
public class MongoDemon2 {
    public static void main(String[] args) {
        MongoClient client=new MongoClient("172.17.208.245");//创建连接
        MongoDatabase spitdb = client.getDatabase("spitdb");//打开数据库
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        Map<String,Object> map=new HashMap();
        map.put("content","我要吐槽");
        map.put("userid","9999");
        map.put("visits",123);
        map.put("publishtime",new Date());
        Document document=new Document(map);
        spit.insertOne(document);//插入数据
        client.close();

    }
}
