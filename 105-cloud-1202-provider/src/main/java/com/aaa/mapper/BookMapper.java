package com.aaa.mapper;

import com.aaa.model.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    /**
     * 拿到所有书籍
     * @return
     */
    @Select("select * from book_info")
    List<BookInfo> getAllBook();
}