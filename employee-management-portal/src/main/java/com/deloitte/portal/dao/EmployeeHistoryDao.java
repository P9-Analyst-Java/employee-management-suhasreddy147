package com.deloitte.portal.dao;

import java.util.List;

import com.deloitte.portal.model.EmploymentHistory;

public interface EmployeeHistoryDao {

	List<EmploymentHistory> searchByEmployeeId(int id);
}
