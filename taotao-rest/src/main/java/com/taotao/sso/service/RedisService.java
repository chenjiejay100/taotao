package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by bing on 2017/7/22.
 */
public interface RedisService {
    TaotaoResult syncContent(long contentCid);
}
