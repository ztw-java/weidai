package com.ztw.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Describe
 * @Author zhongtw
 * @Date 2018/6/30 16:02
 **/
@Data
public class Goods implements Serializable {

    private Long id;

    private String name;

    private Float price;

    private LocalDate publishingTime;

}
