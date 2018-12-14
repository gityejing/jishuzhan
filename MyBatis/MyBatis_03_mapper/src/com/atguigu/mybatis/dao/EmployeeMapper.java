package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	// 多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
	// @MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
	// 如果key值重复
	@MapKey("id")
	public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(@Param("lastName") String lastName);
	
	@MapKey("id")
	public Map<Integer, Employee> getEmpReturnMap();
	
	// 返回一条记录的map；key就是列名，值就是对应的值
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String, Object> map);
	
	public Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	
	public Employee getEmpById(Integer id);

	
	/**
	 *    基本的增删改,在xml文件中，没有resultType，如果想要有返回值，
	 *    这里可以直接加上返回值就可以了，但是仅限于如下返回类型：
	 * Long,Integer,Boolean
	 */
	public Long addEmp(Employee employee);
	public boolean updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
	
}
