package com.mybatisplusdemo.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 图书实体
 * 使用AR模式，Active Record
 *
 */
@TableName("books") // 映射表
public class Book extends Model<Book> {
	/**
	 * 编号
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private int id;
	/**
	 * 书名
	 */
	private String title;
	/**
	 * 价格
	 */
	private double price;
	/**
	 * 出版日期
	 */
	@TableField("publishDate") // 映射字段
	private Date publishDate;

	public Book(int id, String title, double price, Date publishDate) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
	}

	public Book() {
	}

	public Book(int id) {
		this.id = id;
	}

	/**
	 * 实现抽象方法
	 * 这个方法的作用是：用来指定当前当前实体类的主键属性,就是用哪个属性对应数据库中的主键
	 * @return
	 */
	@Override
	protected Serializable pkVal() {
		return id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", publishDate=" + publishDate + "]";
	}

}