package com.deloitte.portal.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.deloitte.portal.model.EmploymentHistory;

@Repository
public class EmployeeHistoryDaoImpl implements EmployeeHistoryDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<EmploymentHistory> searchByEmployeeId(int id) {
		return jdbcTemplate.query("select * from employment_history where emp_id=?",
				new BeanPropertyRowMapper<EmploymentHistory>(EmploymentHistory.class),id);
	}

}
