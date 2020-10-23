package cn.test.manager.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzf
 * @since 2019-09-28
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("ID")
	private Integer id;
    /**
     * 名称
     */
	private String username;
    /**
     * 邮件
     */
	private String sex;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			", id=" + id +
			", username=" + username +
			", sex=" + sex +
			"}";
	}
}
