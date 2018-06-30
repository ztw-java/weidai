package com.ztw.redis;

import com.ztw.entity.Goods;
import com.ztw.service.GoodsService;
import com.ztw.service.UserService;
import com.ztw.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CacheTest extends BaseTest {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserServiceImpl userServiceImpl;

    @Autowired
    private GoodsService goodsService;

    @Test
    public void test003(){
        System.out.println(goodsService.goodsList("ztw"));
        System.out.println(goodsService.goodsList("ztw"));
        System.out.println(goodsService.goodsList("zjl"));
        System.out.println(goodsService.goodsList("zjl"));
        System.out.println(goodsService.goodsList("zjl"));
    }

    @Test
    public void test004(){
        String author = "ztw";
        List<Goods> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Goods record = new Goods();
            record.setId((long) i);
            record.setName(author.concat("第").concat(String.valueOf(i).concat("本书")));
            record.setPrice(10000f);
            record.setPublishingTime(LocalDate.of(2018, 8, i + 1));
            list.add(record);
        }
        System.out.println(goodsService.goodsList("ztw"));
        goodsService.updateGoods(author, list);
        System.out.println(goodsService.goodsList("ztw"));
//        goodsService.deleteGoods("ztw");
//        goodsService.updateGoods(author, list);
    }


    @Test
    public void test001(){
        try {
            System.out.println(userService.getUserById(20180630l));
            System.out.println(userService.getUserById(20180630l));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test002(){
        try {
//            System.out.println(userServiceImpl.getName(20180631l));
//            System.out.println(userServiceImpl.getName(20180631l));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
