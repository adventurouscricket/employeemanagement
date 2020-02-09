package com.mrhenry.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrhenry.dto.EmployeeDTO;
import com.mrhenry.repository.IEmployeeRepository;
import com.mrhenry.service.IEmployeeService;
import com.mrhenry.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-employee"})
public class EmployeeAPI extends HttpServlet {
	
	private static final long serialVersionUID = -77606861423213187L;

	@Inject
	IEmployeeService employeeService;
	
	// add new
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		EmployeeDTO building = HttpUtil.of(request.getReader()).toModel(EmployeeDTO.class);
		building = employeeService.save(building);
		mapper.writeValue(response.getOutputStream(), building);
	}
	
	// edit
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		EmployeeDTO building = HttpUtil.of(request.getReader()).toModel(EmployeeDTO.class);
		employeeService.update(building, building.getId());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
	
	// delete
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			EmployeeDTO building = HttpUtil.of(request.getReader()).toModel(EmployeeDTO.class);
			employeeService.delete(building.getId());
			mapper.writeValue(response.getOutputStream(), "{}");
		}
}
