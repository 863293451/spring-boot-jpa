package com.jk.service.impl;

import com.jk.mapper.Iboosmapper;
import com.jk.dao.IboosDao;
import com.jk.pojo.boos;
import com.jk.service.IboosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.jk.dao.IjdbcDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  接口 实现类
 */
@Service
public class boosServiceImpl implements IboosService {


    // 注入   JPA  使用服务
    @Autowired
    private IboosDao iboosDao;

    // 增加
    public void saveBoos(boos s1) {
        iboosDao.save(s1);
    }
    // 删除单个
    public void deleteboos(Integer id) {
        iboosDao.deleteById(id);
    }
    // 查询
    public List<boos> getAllboos() {
        List<boos> list = iboosDao.findAll();
        return list;
    }

    // -----------------
    //  使用   JdbcTemplate   进行条件查询
    // 注入  JdbcTemplate 服务
    @Autowired
    private IjdbcDao ijdbcDao;

    //  方法走  JdbcTemplate   类 去处理
    public boos getBoosById(Integer id){
        boos boos = ijdbcDao.getBoosById(id);
        return boos;
    }

    // 删除
    public void BoosByidAlly(Integer id) {
        ijdbcDao.BoosByidAlly(id);
    }




    // 注入 mybits 的 服务
    @Autowired
    private Iboosmapper boosmapper;
    // 使用 mybits  进行 查询
    public List<boos> getListboos() {
        List<boos> boosList = boosmapper.getListboos();
        return boosList;
    }

    // 根据 ID 查询
    public  boos getboosByid(@RequestParam Integer id) {
        boos boosAll = boosmapper.getboosByid(id);
        return boosAll;
    }
    // 模糊查询
    public boos getLikeName(String bookName){
        boos getLikeNameAll = boosmapper.getLikeName(bookName);
        return getLikeNameAll;
    }


}