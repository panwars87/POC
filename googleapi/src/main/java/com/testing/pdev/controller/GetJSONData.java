package com.testing.pdev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.testing.pdev.exceptions.GoogleApiUtilException;
import com.testing.pdev.model.Employee;
import com.testing.pdev.service.EmployeeDAO;
import com.testing.pdev.service.impl.EmployeeDAOImpl;

/**
 * Servlet implementation class GetJSONData
 */
public class GetJSONData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EmployeeDAO empDAO = new EmployeeDAOImpl();
	
	Logger log = LoggerFactory.getLogger(GetJSONData.class);
	
    public GetJSONData() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	// TODO Auto-generated method stub
    	log.info("....doGet initiated....");
    	try{
    		PrintWriter out = response.getWriter();
    		JSONObject jsonObj = new JSONObject();

    		List<Employee> employeeList = empDAO.getEmployeeNameQuery("health +Permanente");

    		if(employeeList != null){
    			log.info("Converting to json");
    			jsonObj.put("employees", objectToJSON(employeeList));
    			jsonObj.put("status", true);
    		}else{
    			log.error("Employee list is empty");
    			jsonObj.put("status", false);
    		}

    		response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
    		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
    		response.getWriter().write(jsonObj.toString());       // Write response body.
    	}catch(Exception e){
    		throw new ServletException();
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("....doPost initiated....");
		JSONObject jsonObj = new JSONObject();
		
		String searchParam = request.getParameter("searchParam");
		
		if(null != searchParam){
			List<Employee> employeeList = empDAO.getEmployeeNameQuery(searchParam);
			try {
				jsonObj.put("employees", objectToJSON(employeeList));
				jsonObj.put("status", true);
			} catch (Exception e) {
				e.printStackTrace();
				jsonObj.put("status", false);
			}
		}else{
			jsonObj.put("status", false);
		}
		
		response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(jsonObj.toString());       // Write response body.
	}
	
	private String objectToJSON(Object obj) throws GoogleApiUtilException{
		if(obj == null){
			throw new GoogleApiUtilException("Obj to parse is null");
		}else{
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
			try {
				return ow.writeValueAsString(obj);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new GoogleApiUtilException(e.getMessage());
			}
		}
	}

}
