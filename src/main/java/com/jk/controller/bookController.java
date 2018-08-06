package com.jk.controller;

import com.jk.pojo.boos;
import com.jk.service.IboosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 *   控制层
 */
@Controller
@RequestMapping("book")
public class bookController {

    // 简单访问 , 访问方法，走页面
    @RequestMapping("/massage")
    @ResponseBody
    public String getMassage() {
        return "abcd11w2312342wqasdasd123";
    }

    //   简单赋值，在页面查询
    @RequestMapping("/boot")
    @ResponseBody
    public boos toIndex() {
        boos s1 = new boos();
        s1.setId(1);
        s1.setBookName("张三");
        s1.setBookNumber(2);
        s1.setBookPrice(432);
        return s1;
    }


    //    JPA   的   注入
    @Autowired
    private IboosService iboosService;

    //   使用JPA   增加
    @RequestMapping("/saveboos")
    @ResponseBody
    public void saveBoos() {
        boos s1 = new boos();
        s1.setId(3);
        s1.setBookName("张三");
        s1.setBookNumber(2);
        s1.setBookPrice(432);
        iboosService.saveBoos(s1);
    }

    //    使用JPA 进行删除
    @RequestMapping("/deleteboos")
    @ResponseBody
    public void deleteboos() {
        Integer id = 2;
        iboosService.deleteboos(id);
    }

    //    查询全部
    @RequestMapping("/getAllboos")
    @ResponseBody
    public List<boos> getAllboos() {
        List<boos> list =  iboosService.getAllboos();
        return list;
    }


    //   -------------------
   //  使用   JdbcTemplate    根据 ID 查询
    @RequestMapping("/getBoos")
    @ResponseBody
    public  boos getBoosById() {
        boos boos =  iboosService.getBoosById(1);
        return boos;
    }

    // 删除
    @RequestMapping("/BoosByidAlly")
    @ResponseBody
    public  void BoosByidAlly(Integer id) {
        iboosService.BoosByidAlly(id);
    }

    // 使用 mybits  服务
    // 查询
    @RequestMapping("/getListboos")
    @ResponseBody
    public  List<boos> getListboos() {
        List<boos> boosList = iboosService.getListboos();
        return boosList;
    }

    // 根据 ID 查询
    @RequestMapping("/getboosByid")
    @ResponseBody
    public  boos getboosByid(@RequestParam Integer id) {
        boos boosAll = iboosService.getboosByid(id);
        return boosAll;
    }

    // 模糊查询
    @RequestMapping("/getLikeName")
    @ResponseBody
    public boos getLikeName(@RequestParam String bookName){
        boos getLikeNameAll = iboosService.getLikeName(bookName);
        return getLikeNameAll;
    }


    /**
     * SpringBoot整合redis
     */
    @Autowired
    private RedisTemplate redisTemplate;

    //redis存值
    @ResponseBody
    @RequestMapping("/setRedis")
    public String setRedis(){
        ValueOperations valueOperations = redisTemplate.opsForValue();

        boos s1 = new boos();
        s1.setId(2);
        s1.setBookName("daadad");
        s1.setBookNumber(2);
        s1.setBookPrice(432);
        valueOperations.set("1801",s1);  //1801是一个名字，取出的时候可以根据1801来取值
        return "1";
    }

    //redis取值
    @ResponseBody
    @RequestMapping("/getRedis")
    public boos getRedis(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        boos boos = (boos) valueOperations.get("1801");
        return boos;
    }

    /**
     * SpringBoot整合MongoDB
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    //存入mongodb
    @ResponseBody
    @RequestMapping("setMongoDB")
    public String setMongoDB(){
        boos s1 = new boos();
        s1.setId(3);
        s1.setBookName("张三");
        s1.setBookNumber(2);
        s1.setBookPrice(432);
        mongoTemplate.save(s1);
        return "1";
    }

}