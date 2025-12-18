package com.xiaoniucode.timeline.trail.service;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * 文件上传服务接口
 *
 * @author
 */
public interface FileService {
    /**
     * 文件上传
     *
     * @param file 文件
     * @return 上传后访问地址
     */
    String uploadFile(MultipartFile file, HttpServletRequest request);

}
