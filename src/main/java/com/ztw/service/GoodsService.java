package com.ztw.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.ztw.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author zhongtw
 * @Date 2018/6/30 16:01
 **/

@Slf4j
@Service
public class GoodsService {

    /**
     * 根据作者名字查询书本信息
     *
     * @return
     */
    @Cached(name = "goodsListCache.", key="#author", expire = 3600, cacheType = CacheType.REMOTE)
    public List<Goods> goodsList(String author) {
        log.info("{} | 根据作者查询书本集合", author);
        List<Goods> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Goods record = new Goods();
            record.setId((long) i);
            record.setName(author.concat("第").concat(String.valueOf(i).concat("本书")));
            record.setPrice(60.5f);
            record.setPublishingTime(LocalDate.of(2018, 8, i + 1));
            list.add(record);
        }
        return list;
    }


    /**
     * 根据作者名字更新书本信息
     * @param author
     * @param list
     */
    @CacheUpdate(name = "goodsListCache.", key="#author", value = "#list")
    public void updateGoods(String author, List<Goods> list) {
        log.info("进行数据库更新操作");
    }

    /**
     * 删除缓存
     * @param author
     */
    @CacheInvalidate(name = "goodsListCache.", key="#author")
    public void deleteGoods(String author){
        log.info("删除缓存");
    }

}
