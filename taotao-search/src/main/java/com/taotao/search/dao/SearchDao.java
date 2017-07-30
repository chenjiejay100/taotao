package com.taotao.search.dao;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Created by bing on 2017/7/23.
 */
public interface SearchDao {
    SearchResult search(SolrQuery query) throws Exception;
}
