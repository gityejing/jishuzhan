package com.atguigu.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	public Employee getEmpById(@Param("id") Integer id);
	public Integer deleteById(@Param("id") Integer id); 
	public Integer deleteByIdArray(/*@Param("idArray")*/ Integer[] idArray);
	public void insertEmp(Employee employee);
	public Integer updateEmp(Employee emp);

}
