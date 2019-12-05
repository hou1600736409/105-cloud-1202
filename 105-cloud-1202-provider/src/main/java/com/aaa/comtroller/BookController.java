package com.aaa.comtroller;

import com.aaa.model.BookInfo;
import com.aaa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("getAllBook")
    public List<BookInfo> getAllBook() {
        List<BookInfo> allBook = bookService.getAllBook();

//        try {
//            Thread.sleep(15000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return allBook;
    }

}