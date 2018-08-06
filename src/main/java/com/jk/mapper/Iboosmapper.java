package com.jk.mapper;

import com.jk.pojo.boos;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *   使用 mybits  进行
 */
public interface Iboosmapper {

    // 使用 mybits  进行 查询
    @Select(" select id as id, book_name as bookName, book_number as bookNumber,book_price as bookPrice from boos ")
    List<boos>  getListboos();


    // 根据  ID 查询
    @Select(" select id as id, book_name as bookName, book_number as bookNumber,book_price as bookPrice from boos where id = #{id}")
    boos getboosByid(Integer id);

    @Select(" select id as id, book_name as bookName, book_number as bookNumber,book_price as bookPrice from boos where book_name like CONCAT('%',#{bookName},'%')")
    boos getLikeName(String bookName);




}