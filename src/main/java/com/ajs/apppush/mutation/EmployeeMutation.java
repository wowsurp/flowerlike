package com.ajs.apppush.mutation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.Employee;
import com.ajs.apppush.input.EmployeeInput.GetEmployeeInput;
import com.ajs.apppush.input.EmployeeInput.SaveEmployeeInput;
import com.ajs.apppush.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class EmployeeMutation implements GraphQLMutationResolver{

	private EmployeeRepository employeeRepository;
	
	public EmployeeMutation(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee getEmployee(GetEmployeeInput employeeInput) {
		
		Employee employee = null;
		
		Optional<Employee> opEmployee = employeeRepository.findById(employeeInput.getIdx());
		
		if(opEmployee.isPresent()) {
			employee = opEmployee.get();
		}
		
		return employee;
		
	}
	
	public Employee saveEmployee(SaveEmployeeInput employeeInput) {
		
		Employee employee = null;
		
		Optional<Employee> opEmployee = employeeRepository.findById(employeeInput.getIdx());
		
		if(opEmployee.isPresent()) {
			
			employee = opEmployee.get();
			
			employee.setEnterpriseIdx(employeeInput.getEnterpriseIdx());
			employee.setUserId(employeeInput.getUserId());
			employee.setNickNm(employeeInput.getNickNm());
			employee.setIntroduction(employeeInput.getIntroduction());
			employee.setWorkingHours(employeeInput.getWorkingHours());
			employee.setDelYn(employeeInput.getDelYn());
			employee.setRequestAgreeYn(employeeInput.getRequestAgreeYn());
			employee.setStartDtm(employeeInput.getStartDtm());
			employee.setEndDtm(employeeInput.getEndDtm());
			
		} else {
			
			employee = new Employee();
			
			employee.setEnterpriseIdx(employeeInput.getEnterpriseIdx());
			employee.setUserId(employeeInput.getUserId());
			employee.setNickNm(employeeInput.getNickNm());
			employee.setIntroduction(employeeInput.getIntroduction());
			employee.setWorkingHours(employeeInput.getWorkingHours());
			employee.setDelYn(employeeInput.getDelYn());
			employee.setRequestAgreeYn(employeeInput.getRequestAgreeYn());
			employee.setStartDtm(employeeInput.getStartDtm());
			employee.setEndDtm(employeeInput.getEndDtm());
			
		}
		
		return employeeRepository.save(employee);
	}
	
}
