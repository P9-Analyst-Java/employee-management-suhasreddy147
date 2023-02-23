package com.deloitte.portal.controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.deloitte.portal.dao.EmployeeDao;
import com.deloitte.portal.dao.EmployeeHistoryDao;
import com.deloitte.portal.model.Employee;
import com.deloitte.portal.model.EmploymentHistory;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class MasterController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	EmployeeHistoryDao employeeHistoryDao;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav=new ModelAndView("home");
		List<Employee> employeeList=employeeDao.getAll();
		//System.out.println(expenses);
		mav.addObject("employeeList",employeeList);
		return mav;
	}
	
	@RequestMapping(value="/employments/{empId}")
	public ModelAndView viewEmployments(@PathVariable("empId")int id) {
		ModelAndView mav=new ModelAndView("employments");
		List<EmploymentHistory> employmentList=employeeHistoryDao.searchByEmployeeId(id);
		mav.addObject("employmentList",employmentList);
		mav.addObject("name",employeeDao.searchEmployeeById(id));
		return mav;
	}
	
	@RequestMapping(value="/employeesave",method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("employee")Employee emp, BindingResult br) {
		if(br.hasErrors()) {
			System.out.println("errors");
			return "employee";
		}
		else {
			System.out.println("No errors");
			employeeDao.addOrUpdateEmployee(emp);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/export",method=RequestMethod.GET)
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Employee_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
         
        List<Employee> listUsers = employeeDao.getAll();
 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Emp Id", "Name", "Doj", "Post", "Level","Mobile","Personal Mail","Office Mail","Dob",
        		"Blood Group","Pan no","Aadhar no"};
        String[] nameMapping = {"empId", "firstName", "doj", "postName", "empLevel","mobileNum","emailId","officeMail","dob",
        		"bloodGroup","panNum","aadharNum"};
         
        csvWriter.writeHeader(csvHeader);
         
        for (Employee user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
         
        csvWriter.close();
         
    }
	
//	@RequestMapping(value="/employee")
//	public ModelAndView addEmployee() {
//		ModelAndView mav=new ModelAndView("employee");
//		mav.addObject("employee",new Employee());
//		return mav;
//	}
	
	@RequestMapping(value="/employee")
	public String addEmployee(Model m) {
		m.addAttribute("employee",new Employee());
		return "employee";
	}
	
//	@RequestMapping(value="/employee/{empId}")
//	public ModelAndView edit(@PathVariable("empId")int id) {
//		ModelAndView mav=new ModelAndView("employee");
//		Employee employee = employeeDao.searchEmployeeById(id);
//		mav.addObject("employee",employee);
//		return mav;
//	}
	
	@RequestMapping(value="/employee/{empId}")
	public String edit(@PathVariable("empId")int id,Model m) {
		Employee employee = employeeDao.searchEmployeeById(id);
		m.addAttribute("employee",employee);
		return "employee";
	}

	@RequestMapping(value="/{empId}")
	public String delete(@PathVariable("empId")Integer id) {
		employeeDao.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public ModelAndView search(@Param("empId")Integer empId,@Param("firstName") String firstName,@Param("gender")String gender, @ModelAttribute("emp")Employee employee) 
	{
		ModelAndView mav = new ModelAndView("home");
		List<Employee> employeeList = new ArrayList<>();
		if(empId !=0){
			employee = employeeDao.searchEmployeeById(empId);
			employeeList.add(employee);
		}
		else if(firstName.equals("enter name")|| gender.equals("enter gender"))
		{
			System.out.println("name is null");
		}
		else {
			employeeList= employeeDao.searchEmployeeByNameAndGender(firstName,gender);
		}
		mav.addObject("employeeList",employeeList);
		return mav;
	}
}

