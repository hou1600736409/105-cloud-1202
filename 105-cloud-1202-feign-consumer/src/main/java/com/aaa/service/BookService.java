package com.aaa.service;

import com.aaa.model.BookInfo;
import com.aaa.service.impl.BookServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//声明为FeignClent 并且连接 provider-server
@FeignClient(value = "provider-server",fallback = BookServiceHystrixImpl.class)
public interface BookService {
    /**
     * 得到所有书籍
     *
     * @return 指定链接的 url 和参数  ，其中RequestParam 注解，必须配置，否则找不到参数
     */
    @GetMapping(value = "/getAllBook")
    List<BookInfo> getAllBook();
}