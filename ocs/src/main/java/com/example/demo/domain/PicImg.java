package com.example.demo.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "picimg")
public class PicImg {
	@Id
	@GeneratedValue
	private Integer id;
	private String picimg;


	public PicImg() {//必须要有构造函数才会创建数据库
		
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer ids) {
		this.id=ids;
	}
	
	public String getPicimg() {
		return picimg;
		
	}
	public void setPicimg(String picimg) {
		this.picimg=picimg;
	}

	@Override
    public String toString() {
        return "PicImg{" +
                "id=" + id +
                ", picimg='" + picimg + '\'' +
                '}';
    }
}
