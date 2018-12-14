package com.mybatisplusdemo.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * ͼ��ʵ��
 * ʹ��ARģʽ��Active Record
 *
 */
@TableName("books") // ӳ���
public class Book extends Model<Book> {
	/**
	 * ���
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private int id;
	/**
	 * ����
	 */
	private String title;
	/**
	 * �۸�
	 */
	private double price;
	/**
	 * ��������
	 */
	@TableField("publishDate") // ӳ���ֶ�
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
	 * ʵ�ֳ��󷽷�
	 * ��������������ǣ�����ָ����ǰ��ǰʵ�������������,�������ĸ����Զ�Ӧ���ݿ��е�����
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