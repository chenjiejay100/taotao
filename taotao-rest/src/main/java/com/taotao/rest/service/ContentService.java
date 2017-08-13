package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by bing on 2017/7/5.
 */
public interface ContentService {
    List<TbContent> getContentList(long contentCid);
}
