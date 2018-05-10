package com.taotao.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by bing on 2018/5/7.
 */
public class SolrCloudTest {
    @Test
    public void testAddDocument() throws Exception {
        //创建一个和solr集群的连接
        //参数就是zookeeper的地址列表，使用逗号分隔
        String zkHost = "192.168.137.7:2181,192.168.137.7:2182,192.168.137.7:2183";
        CloudSolrServer solrServer = new CloudSolrServer(zkHost);
        //设置默认的collection
        solrServer.setDefaultCollection("collection2");
        //创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        //向文档中添加域
        document.addField("id", "test002");
        document.addField("item_title", "测试商品2");
        document.addField("item_sell_point", "这是一个苹果手机");
        //把文档添加到索引库
        solrServer.add(document);
        //提交
        solrServer.commit();
    }

    @Test
    public void testQueryDocument() throws Exception {
        //创建一个和solr集群的连接
        //参数就是zookeeper的地址列表，使用逗号分
        String zkHost = "192.168.137.7:2181,192.168.137.7:2182,192.168.137.7:2183";
        CloudSolrServer solrServer = new CloudSolrServer(zkHost);
        solrServer.setDefaultCollection("collection2");
        //创建查询对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery("手机");
        //设置分页
        query.setStart(0);
        query.setRows(10);
        //设置默认搜素域，我设置成仅仅以title作为搜索域
//        query.set("df", "item_keywords");
        query.set("df", "item_sell_point");
        //设置高亮显示
        query.setHighlight(true);
        query.addHighlightField("item_sell_point");
        query.setHighlightSimplePre("<em style=\"color:red\">");
        query.setHighlightSimplePost("</em>");

        QueryResponse queryResponse = solrServer.query(query);
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        System.out.println("共有:"+solrDocumentList.getNumFound());
        for (SolrDocument solrDocument : solrDocumentList) {
            System.out.println("id:"+solrDocument.get("id"));
            System.out.println("title:"+solrDocument.get("item_title"));
            System.out.println("desc:"+solrDocument.get("item_sell_point"));
        }

    }

    @Test
    public void testdeleteDocument() throws SolrServerException, IOException {
        //创建一个和solr集群的连接
        //参数就是zookeeper的地址列表，使用逗号分隔
        String zkHost = "192.168.137.7:2181,192.168.137.7:2182,192.168.137.7:2183";
        CloudSolrServer solrServer = new CloudSolrServer(zkHost);
        //设置默认的collection
        solrServer.setDefaultCollection("collection2");


        solrServer.deleteByQuery("*:*");
        solrServer.commit();
    }
}
