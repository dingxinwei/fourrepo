package com.test.controller;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;

@Controller
public class UploadController {
    /**
     * 文件上传
     * @param model
     * @param uname
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload")
    public String upload(Model model,@RequestParam(value = "uname",required = false) String uname,
                         @RequestParam(value = "headimg") MultipartFile file){
        System.out.println("用户名："+uname);
        System.out.println("文件项名称："+file.getName());
        System.out.println("文件名称："+file.getOriginalFilename());
        try {
            file.transferTo(new File("F://upload/"+file.getOriginalFilename()));
            model.addAttribute("msg","文件上传成功");

        }catch (Exception e){
            model.addAttribute("msg","文件上传失败"+e.getMessage());
        }

        return "success";
    }

    /**
     * 文件下载
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(ServletRequest request)throws  Exception{
        HttpHeaders header = new HttpHeaders();
        header.set("Content-Disposition","attachment;filename=index.jsp");
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("index.jsp");
        InputStream is = new FileInputStream(realPath);
        byte[] data = new byte[is.available()];
        is.read(data);
        return new ResponseEntity<byte[]>(data,header, HttpStatus.OK);
    }
}
