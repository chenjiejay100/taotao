package com.taotao.portal.service;

import com.taotao.portal.pojo.SearchResult;

/**
 * Created by bing on 2017/7/23.
 */
public interface SearchService {
    SearchResult search(String queryString, int page);
}
