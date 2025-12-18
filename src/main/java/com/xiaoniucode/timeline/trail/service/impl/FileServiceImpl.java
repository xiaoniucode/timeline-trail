package com.xiaoniucode.timeline.trail.service.impl;



import com.xiaoniucode.timeline.trail.config.BizException;
import com.xiaoniucode.timeline.trail.service.FileService;
import com.xiaoniucode.timeline.trail.util.FileTools;
import com.xiaoniucode.timeline.trail.util.WebUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传服务
 * @author www.xilio.cn
 */
@Service
public class FileServiceImpl implements FileService {
    @Value("${projectName:timeline_trail}")
    private String projectName;
    @Value("${upload.allowedextensions}")
    private String allowedExtensions;

    @Override
    public String uploadFile(MultipartFile file, HttpServletRequest request) {
        if (file == null || file.isEmpty()) {
            throw new BizException("请上传有效文件");
        }
        // 获取文件扩展名
        String fileName = file.getOriginalFilename();
        String extension = fileName != null && fileName.contains(".")
                ? fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase()
                : "";
        if (extension.isEmpty()) {
            throw new BizException("文件扩展名不能为空");
        }
        // 验证扩展名
        List<String> allowedExts = Arrays.asList(allowedExtensions.split(","));
        if (!allowedExts.contains(extension.toLowerCase())) {
            throw new BizException("文件扩展名不被支持: " + extension);
        }
        // 生成唯一文件名
        String uniqueFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileName;
        String fullUploadPath = FileTools.getUploadPath(projectName);
        File dest = new File(fullUploadPath + uniqueFileName);
        // 确保目录存在
        try {
            Files.createDirectories(dest.getParentFile().toPath());
            file.transferTo(dest);
        } catch (IOException e) {
            throw new BizException("文件上传失败: " + e.getMessage());
        }
        return WebUtils.getDomain(request) + "/file/" + uniqueFileName;
    }
}
