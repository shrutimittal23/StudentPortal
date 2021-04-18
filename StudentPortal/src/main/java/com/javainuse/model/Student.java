package com.javainuse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "Student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int stuid;

	@NotBlank(message = "Name needed")
	private String stu_name;

	public Integer getStuid() {
		return stuid;
	}

	public void setStu_id(Integer stuid) {
		this.stuid = stuid;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

}
