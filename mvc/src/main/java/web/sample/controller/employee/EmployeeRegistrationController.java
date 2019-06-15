package web.sample.controller.employee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.sample.service.employee.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeRegistrationController {
     @Autowired
     EmployeeService employeeService;  
	 //commit test
     //commit test2
     //commit test3
     //commit test5
     //commit test41
     //cpmmitt test51
     //lll
     //commit test557
     //commit test999
     //commit kfkfk

	 @RequestMapping(value = "/new", method = RequestMethod.GET)
	 public String newEmp(final ModelMap modelMap) {

		 return "newEmployee";
	 }
	 //committ kfkfkf
	 @RequestMapping(value = "/new", method = RequestMethod.POST)
	 public String newEmpCreate(final HttpServletRequest request) {
		 String name =  request.getParameter("name");
		 Integer id = employeeService.createEmployee(name);
		 return "redirect:/employee/edit?id="+id;
	 }


	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	 public String editEmp(final HttpServletRequest request, @RequestParam(value = "id",
             required = false, defaultValue = "0") final Integer id) {
		 String name = employeeService.getEmployee(id);
		 request.setAttribute("name", name);
		 return "editEmployee";
	 }
	 
	 @RequestMapping(value = "/edit", method = RequestMethod.POST)
	 public String editEmpCreate(final HttpServletRequest request) {
		 String id =  request.getParameter("id");
		 String name =  request.getParameter("name");
		 employeeService.updateEmployee(Integer.parseInt(id), name);;
		 return "redirect:/employee/edit?id="+id;
	 }
	 
}
