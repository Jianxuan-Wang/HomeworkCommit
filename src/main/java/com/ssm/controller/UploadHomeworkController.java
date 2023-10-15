package com.ssm.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.multipart.support.StandardServletMultipartResolver;


import java.io.File;


@Controller
public class UploadHomeworkController {
    @RequestMapping("/tofileupload")
    public String toFileUpload(){
        return "submithomework";
    }
    @PostMapping(value = "/fileupload")
    public String fileupload(HttpServletRequest request, Model model) throws Exception {
// 先获取到要上传的文件目录
        MultipartResolver resolver = new StandardServletMultipartResolver();

        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        MultipartFile file = multipartRequest.getFile("uploadfile");
        String description = request.getParameter("description");

        if(file==null){
            model.addAttribute("message","请选择文件！");
            return "success";
        }
        String path = description;
        File filePath = new File(path);
        String fileName = file.getOriginalFilename();
        File dest = new File(filePath.getAbsolutePath() + "/" + fileName);
        if (!filePath.exists()) {
            boolean b = filePath.mkdirs();
            if(!b){
                model.addAttribute("message","地址创建失败，请联系管理员！");
                return "success";
            }
        }
        file.transferTo(dest);
        model.addAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
        return "success";
    }
}
