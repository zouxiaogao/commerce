package com.neusoft.commerce.ctrls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;

/**
 * @Author zqy
 * @Date 2019/07/26
 */
@Controller
public class UploadCtrl extends BaseCtrl{

    @Value("${uploadpath}")
    private String uploadpath;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file) throws IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();

        file.transferTo(new File(uploadpath+fileName));
        System.out.println(fileName);
        return fileName;
    }
}
