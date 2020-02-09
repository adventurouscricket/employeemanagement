package com.mrhenry.controller;

import com.mrhenry.dto.EmployeeDTO;
import com.mrhenry.service.IEmployeeService;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(urlPatterns = "/admin-employee")
public class EmployeeController extends HttpServlet {
    @Inject
    private IEmployeeService employeeService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDTO model = new EmployeeDTO();
        try {
            BeanUtils.populate(model, request.getParameterMap());
            String url = "";
            if(model.getAction().equals("list")) {
                url="/views/employee/list.jsp";
                model.setResults(employeeService.findAll());
            } else if(model.getAction().equals("addnew")) {
            	 url="/views/employee/edit.jsp";
            } else if(model.getAction().equals("edit")) { 
//                model = employeeService.findById(model.getId());
                url="/views/employee/update.jsp";
            } else if(model.getAction().equals("delete")) { 
//              model = employeeService.findById(model.getId());
              url="/views/employee/delete.jsp";
          }
            request.setAttribute("model", model);
            request.setAttribute("models", model.getResults());
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
