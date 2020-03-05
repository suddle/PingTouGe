package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sign")
public class Sign {
	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String sign;

	public Sign() {//必须要有构造函数才会创建数据库
		
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer ids) {
		this.id=ids;
	}
	
	public String getUsername() {
		return this.username;
		
	}
	public void setUsername(String usernames) {
		this.username=usernames;
	}
	
	public String getSign() {
		return this.sign;
	}
	public void setSign(String signs) {
		this.sign=signs;
	}
	
	
	@Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", giftname='" + sign + '\'' +
                '}';
    }
}
