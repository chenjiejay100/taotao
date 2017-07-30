package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 * Created by bing on 2017/7/23.
 */
public interface SearchService {
    SearchResult search(String queryString, int page, int rows) throws Exception;
}
