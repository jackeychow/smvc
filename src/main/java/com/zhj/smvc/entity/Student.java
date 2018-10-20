package com.zhj.smvc.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Jc
 * @since 2018-10-10
 */
@Setter
@Getter
@ToString
public class Student extends Model<Student> {

    private static final long  serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer            id;
    /**
     * 姓名
     */
    private String             username;
    /**
     * 性别
     */
    private String             sex;
    /**
     * 学校
     */
    private String             schoolname;
    private Integer            roleid;

    public static final String ID               = "id";

    public static final String USERNAME         = "username";

    public static final String SEX              = "sex";

    public static final String SCHOOLNAME       = "schoolname";

    public static final String ROLEID           = "roleid";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
