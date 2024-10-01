package org.example.employtracker.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.example.employtracker.dao.IEmployeeDao;
import org.example.employtracker.dao.impl.EmployeeDaoImpl;
import org.example.employtracker.service.IEmployeeService;
import org.example.employtracker.service.impl.EmployeeServiceImpl;

import java.io.IOException;

public class EmployeeController extends HttpServlet {
   private IEmployeeDao employeeDao;
   private IEmployeeService employeeService;

   public EmployeeController(){
      this.employeeDao = new EmployeeDaoImpl();
      this.employeeService = new EmployeeServiceImpl(employeeDao);
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = request.getParameter("action");

      switch (action) {
         case "showForm":
            showEmployeeForm(request, response);
            break;
         default:
            break;
      }
   }

   private void showEmployeeForm(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
      dispatcher.forward(request, response);
   }
}
