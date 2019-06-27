package com.clownfish7;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author yzy
 * @classname MongoDemo
 * @description TODO
 * @create 2019-06-27 15:52
 */
@SuppressWarnings("all")
public class MongoDemo {

    /**
     * MongoDb入门小demo
     */
    public static void main(String[] args) {
        MongoClient client = new MongoClient("172.17.208.245");//创建连接
        MongoDatabase spitdb = client.getDatabase("spitdb");//打开数据库
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        FindIterable<Document> documents = spit.find();//查询记录获取文档集合
        for(Document document:documents){ //
            System.out.println("内容："+ document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
//            System.out.println("浏览量："+document.getInteger("visits"));
        }
        client.close();//关闭连接

    }
}
