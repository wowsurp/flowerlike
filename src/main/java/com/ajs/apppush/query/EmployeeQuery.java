//package com.ajs.apppush.query;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ajs.apppush.entity.Employee;
//import com.ajs.apppush.repository.EmployeeRepository;
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//
//@Component
//public class EmployeeQuery implements GraphQLQueryResolver{
//	
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	
//	public EmployeeQuery(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}
//	
//	public Iterable<Employee> getAllEmployee(){
//		return employeeRepository.findAll();
//	}
//
//	public Employee getEmployee(int idx) {
//		
//		Employee employee = null;
//		
//		Optional<Employee> opEmployee = employeeRepository.findById(idx);
//		
//		if(opEmployee.isPresent()) {
//			employee = opEmployee.get();
//		}
//		
//		return employee;
//		
//	}
//	
//}
