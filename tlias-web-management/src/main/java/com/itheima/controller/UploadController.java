package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    /**
     * 本地存储文件
     * @param username
     * @param age
     * @param image
     * @return
     * @throws Exception
     */
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
//        log.info("文件上传：{},{},{}",username,age,image);
//        // 获取原始文件名
//        String originalFilename = image.getOriginalFilename();
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index); // 文件拓展名
//        String newFilename = UUID.randomUUID().toString() + extname;
//        log.info("新文件名：{}",newFilename);
//
//        // 将文件存储在本地服务器的磁盘目录上
//        image.transferTo(new File("C:\\Users\\jzr\\Desktop\\"+newFilename));
//
//        return Result.success();
//    }

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名：{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问的url：{}",url);

        return Result.success(url);
    }
}
