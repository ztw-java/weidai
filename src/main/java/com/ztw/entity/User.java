package com.ztw.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long userId;

    private String name;

    private int gender;

}
