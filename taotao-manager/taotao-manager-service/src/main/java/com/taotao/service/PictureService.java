package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by bing on 2017/7/26.
 */
public interface PictureService {
    PictureResult uploadFile(MultipartFile uploadFile) throws Exception;
}
