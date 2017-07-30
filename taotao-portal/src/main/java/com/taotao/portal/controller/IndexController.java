package com.taotao.portal.controller;

import com.taotao.portal.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by bing on 2017/7/2.
 */
@Controller
public class IndexController {
    @Resource
    private ContentService contentService;
    @RequestMapping("/index")
    public String showIndex(Model model) {
        String adJson = contentService.getContentList();
        model.addAttribute("ad1", adJson);

        return "index";

    }
}
