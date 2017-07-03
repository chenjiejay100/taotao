package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by bing on 2017/7/1.
 */
public interface ItemParamService {
    TaotaoResult getItemParamByCid(long cid);
    public TaotaoResult insertItemParam(TbItemParam itemParam);
}
