package com.jk.service;

        import com.jk.pojo.boos;
        import java.util.List;

public interface IboosService {

    // 增加
    void saveBoos(boos s1);

    void deleteboos(Integer id);

    List<boos> getAllboos();


    //  使用 jdbcTemplate
    // 查询
    boos getBoosById(Integer id);

    // 删除
      void BoosByidAlly(Integer id);


    // 使用 mybits 服务
    //
    //  查询
    List<boos> getListboos();

    // 根据ID 查询
    boos getboosByid(Integer id);

    // 模糊查询
    boos getLikeName(String bookName);



}
