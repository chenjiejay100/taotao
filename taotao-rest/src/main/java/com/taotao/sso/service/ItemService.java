package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by bing on 2017/8/1.
 */
public interface ItemService {
    TaotaoResult getItemBaseInfo(long itemId);

    TaotaoResult getItemDesc(long itemId);

    TaotaoResult getItemParam(long itemId);
}
