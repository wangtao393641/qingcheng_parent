package com.qingcheng.controller.file;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private HttpServletRequest request;

    /**
     * 本地上传
     *
     * @param file
     * @return
     */
    @PostMapping("/native")
    public String nativeUpload(@RequestParam("file") MultipartFile file) {
        //获取img的绝对路径
        String path = request.getSession().getServletContext().getRealPath("img");
        //获取文件名
        String filePath = path + "/" + file.getOriginalFilename();
        //目标路径
        File desFile = new File(filePath);
        if (!desFile.getParentFile().exists()) {
            desFile.mkdirs();
        }

        try {
            file.transferTo(desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost:9101/img/" + file.getOriginalFilename();
    }

    @Autowired
    private OSSClient ossClient;

    @PostMapping("/oss")
    public String ossUpload(@RequestParam("file") MultipartFile file, String folder) {
        String bucketName = "qingchengdianzishangw";
        String fileName = folder + "/" + UUID.randomUUID() + file.getOriginalFilename();
        try {
            ossClient.putObject(bucketName, fileName, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "https://"+bucketName+".oss‐cn‐beijing.aliyuncs.com/"+fileName;
    }
}