package com.xiaoniucode.timeline.trail.controller.admin;


import com.xiaoniucode.timeline.trail.config.Ajax;
import com.xiaoniucode.timeline.trail.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;


/**
 * 文件上传
 * @author xiaoniu
 */
@RestController
@RequestMapping("/admin/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping(value = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,name = "文件上传")
    public Ajax uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
         return Ajax.success(fileService.uploadFile(file,request));
    }
}
