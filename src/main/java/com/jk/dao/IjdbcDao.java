package com.jk.dao;

import com.jk.pojo.boos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *   jdbcTemplate  页面
 */
@Repository
public class IjdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //   根据ID 查询
    public boos getBoosById(Integer id) {
        String sql = "select * from boos where id=?";
        RowMapper<boos> rowMapper = new BeanPropertyRowMapper<boos>(boos.class);
//        String sql1 = "select *from Student where id="+id;
//        jdbcTemplate.queryForObject(sql1,Student.class);
//        jdbcTemplate.execute(sql);
        return jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    public void BoosByidAlly(Integer  id){
        String sql = "DELETE from boos where id = "+id;
        jdbcTemplate.batchUpdate(sql);
    }



}