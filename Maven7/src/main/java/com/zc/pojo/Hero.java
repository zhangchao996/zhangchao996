package com.zc.pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "tb_hero")
public class Hero {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String profession;
    private String phone;
    private String email;
    private Date onlinetime;
    private String abd;
}
