package com.school.pl.controller.erp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.pl.controller.erp.employee.dto.EmployeeRecord;

@RestController 
@RequestMapping("/v1/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeFacade employeeFacade;
	
	@RequestMapping(method = RequestMethod.POST)
	public EmployeeRecord createEmployee(@RequestBody EmployeeRecord employeeRecord){
		return employeeFacade.createNewEmployeeRecord(employeeRecord);
	}

	@RequestMapping(value = "/{employeeId}" ,method = RequestMethod.GET)
	public EmployeeRecord getEmployee(@PathVariable String employeeId){
		return employeeFacade.getEmployeeRecord(employeeId);
	}

	@RequestMapping(value="/{employeeRecordID}", method = RequestMethod.PUT)
	public EmployeeRecord updateEmployee(@PathVariable String employeeRecordID ,@RequestBody EmployeeRecord employeeRecord){
		return employeeFacade.updateEmployeeRecord(employeeRecordID ,employeeRecord);
	}
	
	@RequestMapping(value ="/{employeeRecordId}", method =RequestMethod.DELETE)
	public EmployeeRecord deleteEmployee(@PathVariable String employeeRecordId){
		return employeeFacade.deleteEmployeeRecord(employeeRecordId);
	}
	
	//Filter to be implemented
}
