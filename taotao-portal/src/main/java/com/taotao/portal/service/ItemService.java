package com.taotao.portal.service;

import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.ItemInfo;

/**
 * Created by bing on 2017/8/1.
 */
public interface ItemService {
    ItemInfo getItemById(Long itemId);

    String getItemDescById(Long itemId);

    String getItemParam(Long itemId);
}
