package org.example.employtracker.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.example.employtracker.dao.IEmployeeDao;
import org.example.employtracker.dao.impl.EmployeeDaoImpl;
import org.example.employtracker.model.Employee;
import org.example.employtracker.service.IEmployeeService;
import org.example.employtracker.service.impl.EmployeeServiceImpl;
import org.example.employtracker.util.Validator;

import java.io.IOException;
import java.util.List;

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
         case "addForm":
            showEmployeeForm(request, response);
            break;
         case "showEmployees":
            showListEmployees(request, response);
            break;
         case "updateForm":
            showEditForm(request, response);
            break;
         case "search":
            searchEmployees(request, response);
            break;
         case "filter":
            filterEmployeesByDepartment(request, response);
            break;
         default:
            response.sendRedirect("employee?action=showEmployees");
            break;
      }
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      String action = request.getParameter("action");

      switch (action) {
         case "insert":
            insertEmployee(request, response);
            break;
         case "delete":
            deleteEmployee(request, response);
            break;
         case "update":
            updateEmployee(request, response);
            break;
         default:
            response.sendRedirect("employee?action=showEmployees");
            break;
      }
   }

   private void showEmployeeForm(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      RequestDispatcher dispatcher = request.getRequestDispatcher("views/addForm.jsp");
      dispatcher.forward(request, response);
   }

   private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      Employee existingEmployee = employeeService.getEmployeeById(id);
      request.setAttribute("employee", existingEmployee);
      RequestDispatcher dispatcher = request.getRequestDispatcher("views/updateForm.jsp");
      dispatcher.forward(request, response);
   }


   private void showListEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      List<Employee> employees = employeeService.getAllEmployees();
      List<String> listOfDepartments = employeeService.getDistinctDepartments();
      request.setAttribute("listOfDepartments", listOfDepartments);
      System.out.println(listOfDepartments);
      request.setAttribute("employees", employees);
      RequestDispatcher dispatcher = request.getRequestDispatcher("views/employeesList.jsp");
      dispatcher.forward(request, response);
      System.out.println(employees);
   }

   private void searchEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String query = request.getParameter("searchQuery");
      List<Employee> employees = employeeService.searchEmployees(query);
      List<String> listOfDepartments = employeeService.getDistinctDepartments();
      request.setAttribute("listOfDepartments", listOfDepartments);
      request.setAttribute("employees", employees);
      RequestDispatcher dispatcher = request.getRequestDispatcher("views/employeesList.jsp");
      dispatcher.forward(request, response);
   }

   private void filterEmployeesByDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String department = request.getParameter("department");

      if(department == null || department.trim().isEmpty()){
         response.sendRedirect("employee?action=showEmployees");
         return;
      }
      List<String> listOfDepartments = employeeService.getDistinctDepartments();
      List<Employee> employees = employeeService.getEmployeesByDepartment(department);
      request.setAttribute("employees", employees);
      request.setAttribute("listOfDepartments", listOfDepartments);
      RequestDispatcher dispatcher = request.getRequestDispatcher("views/employeesList.jsp");
      dispatcher.forward(request, response);
   }

   private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
      String firstName = request.getParameter("first_name");
      String lastName = request.getParameter("last_name");
      String email = request.getParameter("email");
      String phoneNumber = request.getParameter("phone_number");
      String department = request.getParameter("department");
      Double salary = Double.valueOf(request.getParameter("salary"));
      String validationErrors = Validator.validateEmployeeInputs(firstName, lastName, email, phoneNumber, department, salary);

      if (!validationErrors.isEmpty()) {
         request.setAttribute("errors", validationErrors);
         try {
            request.getRequestDispatcher("views/addForm.jsp").forward(request, response);
         } catch (ServletException e) {
            e.printStackTrace();
         }
         return;
      }

      Employee employee = new Employee(firstName,lastName, email, phoneNumber, department, salary);
      employeeService.addEmployee(employee);
      response.sendRedirect("employee?action=showEmployees");
   }

   private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
      int id = Integer.parseInt(request.getParameter("employeeId"));
      employeeService.deleteEmployee(id);
      response.sendRedirect("employee?action=showEmployees");
   }

   private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      String firstName = request.getParameter("first_name");
      String lastName = request.getParameter("last_name");
      String email = request.getParameter("email");
      String phoneNumber = request.getParameter("phone_number");
      String department = request.getParameter("department");
      Double salary = Double.valueOf(request.getParameter("salary"));
      request.setAttribute("isError", true);

      String validationErrors = Validator.validateEmployeeInputs(firstName, lastName, email, phoneNumber, department, salary);

      if (!validationErrors.isEmpty()) {
         request.setAttribute("errors", validationErrors);
         try {
            showEditForm(request,response);
         } catch (ServletException e) {
            e.printStackTrace();
         }
         return;
      }

      Employee employee = new Employee(id, firstName, lastName, email, phoneNumber, department, salary);
      employeeService.updateEmployee(employee);

      response.sendRedirect("employee?action=showEmployees");
   }
}
