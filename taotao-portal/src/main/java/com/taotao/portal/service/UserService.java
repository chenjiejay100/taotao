package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

/**
 * Created by bing on 2017/8/2.
 */
public interface UserService {
    TbUser getUserByToken(String token);
}
