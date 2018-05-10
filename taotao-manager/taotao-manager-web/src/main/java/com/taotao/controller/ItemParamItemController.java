package com.taotao.controller;

import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 具体商品的规格参数展现
 * Created by bing on 2017/7/2.
 */
@Controller
public class ItemParamItemController {

    @Autowired
    private ItemParamItemService itemParamItemService;

    @RequestMapping("/showitem/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model) {
        String string = itemParamItemService.getItemParamByItemId(itemId);
        model.addAttribute("itemParam", string);
        return "item";//转到item.jsp
    }
}

