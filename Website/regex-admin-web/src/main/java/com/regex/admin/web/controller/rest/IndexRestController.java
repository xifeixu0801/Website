package com.regex.admin.web.controller.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.regex.admin.web.controller.vo.TestBook;

@RestController
public class IndexRestController {
    
    @RequestMapping("json")
    @ResponseBody
    public  String jsonTest(HttpServletResponse response) {
        TestBook book = new TestBook();
        book.setName("1111");
        book.setAuther("22222");
        book.setPublish("444444");
        String test = JSON.toJSON(book).toString();
        return test;
    }
    
    @RequestMapping("test")
    public TestBook test() {
        TestBook book = new TestBook();
        book.setName("1111");
        book.setAuther("22222");
        book.setPublish("444444");
        return book;
    }
    
}
