package com.test.controller;

import com.test.bean.Address;
import com.test.bean.Goods;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/h")
@Controller
public class FirstController {
    @RequestMapping("/t")
    public String handlerRequest(){
        System.out.println("hello");
        return "success";
    }
    @RequestMapping("/b")
    public String handle01(Goods goods){
        return "success";
    }

    /**
     * 使用forward:进行转发页面
     * redirect:进行重定向
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(){
        System.out.println("handle02");
        return "forward:/index.jsp";
    }

    @RequestMapping("/handle03")
    public String handle03(){
        System.out.println("handle03");
        return "success";
    }
    @RequestMapping("/handle04")
    public String handle04(){
        System.out.println("handle04");
        return "redirect:/h/handle03";
    }

    /**
     *    @ResponseBody 返回json格式的字符串到浏览器
     *    @RequestBody 浏览器发送json格式的字符串，服务器把json字符串封装成java对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/handle05")
    public Goods handle05(){
        Goods goods = new Goods();
        goods.setgName("辣条");
        goods.setgId(1);
        goods.setPrice(2);
        goods.setStock(50);
       Address address = new Address();
       address.setProvince("河南");
       address.setCity("漯河");
       address.setArea("召陵");
        goods.setAddress(address);
        return goods;
    }
    @RequestMapping("/handle06")
    public String handle06(@RequestBody Address address){
        System.out.println(address);
        System.out.println("*************************");
        return "success";
    }
    @RequestMapping("/handle07")
    public ResponseEntity<String> handle07(){

        MultiValueMap<String, String> headers = new HttpHeaders();
       headers.add("Set-Cookie","username=dxw&pwd=123");
        return new ResponseEntity<>("success",headers, HttpStatus.OK);
    }

    /**
     * RequestEntity 获取请求头中的信息
     * ResponseEntity 向响应头中添加信息
     * @param entity
     * @return
     */
    @RequestMapping("/handle08")
    public String handle08(RequestEntity<String> entity){

        System.out.println(entity);
        return  "success";
    }

}

