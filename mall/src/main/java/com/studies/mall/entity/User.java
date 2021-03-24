package com.studies.mall.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 4220515347228129741L;
    private Integer id;
    private String username;
    private Integer age;
    public User(Integer id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public User() {
    }
}
