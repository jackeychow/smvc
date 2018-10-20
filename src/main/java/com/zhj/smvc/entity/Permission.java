package com.zhj.smvc.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jc
 * @since 2018-10-10
 */
@Getter
@Setter
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
	private Integer roleid;

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String ROLEID = "roleid";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Permission{" +
			", id=" + id +
			", name=" + name +
			", roleid=" + roleid +
			"}";
	}
}
