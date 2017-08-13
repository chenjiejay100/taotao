package com.taotao.rest.jedis;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * Created by bing on 2017/7/23.
 */
public class SolrJTest {

    @Test
    public void addDocument() throws Exception {
        //创建一连接
        SolrServer solrServer = new HttpSolrServer("http://192.168.147.130:8080/solr");
        //创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "test002");
        document.addField("item_title", "测试商品2");
        document.addField("item_price", 54321);
        //把文档对象写入索引库
        solrServer.add(document);
        //提交
        solrServer.commit();
    }

    @Test
    public void deleteDocument() throws Exception {
        //创建一连接
        SolrServer solrServer = new HttpSolrServer("http://192.168.147.130:8080/solr");
        //solrServer.deleteById("test001");
        solrServer.deleteByQuery("*:*");
        solrServer.commit();
    }
}

