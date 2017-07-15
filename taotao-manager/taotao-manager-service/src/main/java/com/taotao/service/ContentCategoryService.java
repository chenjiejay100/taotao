package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by bing on 2017/7/4.
 */
public interface ContentCategoryService {
    List<EUTreeNode> getCategoryList(long parentId);

    TaotaoResult insertContentCategory(long parentId, String name);
}
