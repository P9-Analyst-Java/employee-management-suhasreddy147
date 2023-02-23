package com.deloitte.portal.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deloitte.portal.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query("select * from employees order by first_name asc,emp_id asc", 
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from employees where emp_id=?",id);
	}

	@Override
	public int addOrUpdateEmployee(Employee employee) {
		return jdbcTemplate.update("INSERT INTO employees "
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,'C:\\Users\\suhsreddy\\Desktop\\download.png',?,?,?,?,?) "
				+ "on duplicate key update first_name=?,last_name=?,gender=?,dob=?,pan_num=?,aadhar_num=?,"
				+ "mobile_num=?,email_id=?,office_mail=?,permanent_address=?,present_address=?,blood_group=?,"
				+ "doj=?,emp_level=?,post_name=?,basic_pay=?,house_allowance=?",
				new Object[] {employee.getEmpId(),employee.getFirstName(),employee.getLastName(),employee.getGender(),
						employee.getDob(),employee.getPanNum(),employee.getAadharNum(),employee.getMobileNum(), 
						employee.getEmailId(),employee.getOfficeMail(),employee.getPermanentAddress(),
						employee.getPresentAddress(),employee.getBloodGroup(),employee.getDoj(),employee.getEmpLevel(),
						employee.getPostName(),employee.getBasicPay(),employee.getHouseAllowance(),employee.getFirstName(),
						employee.getLastName(),employee.getGender(),employee.getDob(),employee.getPanNum(),
						employee.getAadharNum(),employee.getMobileNum(),employee.getEmailId(),employee.getOfficeMail(),
						employee.getPermanentAddress(),employee.getPresentAddress(),employee.getBloodGroup(),
						employee.getDoj(),employee.getEmpLevel(),employee.getPostName(),employee.getBasicPay(),
						employee.getHouseAllowance()});
	}

	@Override
	public Employee searchEmployeeById(int id) {
		return jdbcTemplate.queryForObject("select * from employees where emp_id=?",
				new BeanPropertyRowMapper<Employee>(Employee.class),id);
	}

	@Override
	public List<Employee> searchEmployeeByNameAndGender(String name,String gender) {
		String sql="select * from employees where gender='"+gender+"' and "
				+ "(first_name like '%"+name+"%' or last_name like '%"+name+"%') order by first_name asc,emp_id asc";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
}
