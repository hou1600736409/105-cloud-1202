package com.aaa.service.impl;

import com.aaa.model.BookInfo;
import com.aaa.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceHystrixImpl implements BookService {
    @Override
    public List<BookInfo> getAllBook() {
        System.out.println("服务奖级中");
        return null;
    }
}
