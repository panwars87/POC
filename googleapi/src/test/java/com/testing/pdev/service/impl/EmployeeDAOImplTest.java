package com.testing.pdev.service.impl;

import static org.junit.Assert.*;

import java.text.MessageFormat;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.testing.pdev.model.Employee;
import com.testing.pdev.service.EmployeeDAO;

public class EmployeeDAOImplTest {

	@Test
	public void testFindById() throws Exception{
		EmployeeDAO eh = new EmployeeDAOImpl();
		eh.findById(256);
	}
	
	@Test
	public void testNamesQuery() throws Exception{
		EmployeeDAO eh = new EmployeeDAOImpl();
		List<Employee> employeeList = eh.getEmployeeNameQuery("health +Permanente");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		JSONObject jsonObj = new JSONObject();
		
		if(employeeList != null){
			jsonObj.put("employees", ow.writeValueAsString(employeeList));
			jsonObj.put("status", true);
		}else{
			jsonObj.put("status", false);
		}
		
		System.out.println(MessageFormat.format("JSON Object is : {0}.", jsonObj.toString()));
		assertEquals(45,employeeList.size());
	}

}
