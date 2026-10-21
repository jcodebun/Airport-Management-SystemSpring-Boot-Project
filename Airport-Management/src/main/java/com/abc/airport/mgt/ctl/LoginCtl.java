package com.abc.airport.mgt.ctl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.ChangePasswordForm;
import com.abc.airport.mgt.form.ForgetPasswordForm;
import com.abc.airport.mgt.form.LoginForm;
import com.abc.airport.mgt.form.ManagerForm;
import com.abc.airport.mgt.form.PilotForm;
import com.abc.airport.mgt.form.UserRegistrationForm;
import com.abc.airport.mgt.service.UserServiceInt;
import com.abc.airport.mgt.util.DataUtility;



















@Controller
public class LoginCtl extends BaseCtl {
	
	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";
	
	@Autowired
	private UserServiceInt userServiceInt;
	
	@GetMapping("/home/signUp")
	public String display(@ModelAttribute("form") UserRegistrationForm form, Model model) {
		log.info("LoginCtl signUp display method start");
		log.info("LoginCtl signUp display method End");
		return "signUp";
	}
	
	@ModelAttribute
	public void preload(Model model) {

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Male", "Male");
		map2.put("Female", "Female");
		model.addAttribute("gender", map2);
		
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("Pilot", "Pilot");
		map3.put("Manager", "Manager");
		model.addAttribute("designation", map3);
		
		HashMap<String, String> map4 = new HashMap<String, String>();
		map4.put("Accept", "Accept");
		map4.put("Reject", "Reject");
		model.addAttribute("statusApproval", map4);

	}
	
	@PostMapping("/home/signUp")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") UserRegistrationForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request) {

		log.info("LoginCtl signUp submit method start");
		

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/signUp";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "signUp";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				UserDTO entity = (UserDTO) populateDTO(form.getDTO(), request);
				
				  int dob = entity.getDob().getYear()+1900; System.out.println("dob "+dob);
				  
				  int current = Calendar.getInstance().get(Calendar.YEAR);
				  System.out.println("current "+current); int age = current - dob;
				  System.out.println("age "+age);
				  if(age < 17) {
					  model.addAttribute("ageError",
				  "Age cannot be less than 17.");
					return "signUp";  
				  }
				 
				System.out.println(entity.toString());
				if(entity.getDesignation().equalsIgnoreCase("Pilot")) {
					entity.setRoleId(3L);  //for pilot 3
				}
				else
				{
					entity.setRoleId(2L);   // for manager 2
				}
				
				userServiceInt.add(entity);
				model.addAttribute("success", "User Registerd Successfully!!!!");
				model.addAttribute("empId", " Your Employee Id is "+ "ID-"+entity.getEmployeeId());
				return "signUp";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "signUp";
		}

		log.info("LoginCtl signUp submit method end");
		return "signUp";
	}
	
	@GetMapping("/home/login")
	public String display(@ModelAttribute("form") LoginForm form,
			HttpSession session, Model model) {
		log.info("LoginCtl login display method start");
		if (session.getAttribute("user") != null) {
			session.invalidate();
			model.addAttribute("success", "You have logout Successfully!!!");
		}
		
		log.info("LoginCtl login display method End");
		return "login";
	}
	@PostMapping("/home/login")
	public String submit(@RequestParam String operation, HttpSession session,
			@Valid @ModelAttribute("form") LoginForm form, BindingResult result, Model model) {
		log.info("LoginCtl login submit method start");
		System.out.println("In dopost  LoginCtl");

		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login";
		}

		if (result.hasErrors()) {
			System.out.println(result);
			return "login";
		}

		UserDTO bean = userServiceInt.authentication((UserDTO) form.getDTO());

		if (bean != null) {
			if(bean.getStatus().equalsIgnoreCase("0")) {
				model.addAttribute("msg", "Wait for Admin to accept");
				return "redirect:/home";
			}
			System.out.println(bean.toString());
			session.setAttribute("user", bean);
				return "redirect:/home";
		}
	//	System.out.println("status "+bean.getStatus());
	
	 if(bean==null) { 
		
		model.addAttribute("error", "Employee Id & Password Invalid");}
		log.info("LoginCtl login submit method End");
		return "login";
	}
	
	@RequestMapping(value = "/home/login/forgetPassword", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") ForgetPasswordForm form, HttpSession session, Model model) {

		System.out.println("In doget LoginCtl forgetpassword");

		return "forgetPassword";

	}

	@RequestMapping(value = "/home/login/forgetPassword", method = RequestMethod.POST)
	public String display(@ModelAttribute("form") @Valid ForgetPasswordForm form, BindingResult bindingResult,
			Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "forgetPassword";
		}
			System.out.println("***Login******"+form.getLogin());
		UserDTO dto = userServiceInt.findByLogin(form.getLogin());
		System.out.println("dto"+dto.getLogin());
		
		if (dto == null) {
			model.addAttribute("error", "Invalid Input Entered");
			return "forgetPassword";
		}

		if (dto != null) {
			 UserDTO u=userServiceInt.findByAll(form.getEmployeeId(),form.getLogin(),form.getSecretAns1(),form.getSecretAns2(),form.getSecretAns3());
			//model.addAttribute("success", "Password has been sent to your registered Email ID!!");
			 if(!DataUtility.getStringData(dto.getLogin()).equalsIgnoreCase(form.getLogin()) ) {
					model.addAttribute("error", "Incorrect details matched");
					return "forgetPassword";
				}
			session.setAttribute("id", form.getEmployeeId());
			System.out.println("****error*****"+form.getEmployeeId());
			model.addAttribute("success", "Password is Sent to Email id");
		}
		return "forgetPassword";
	}
	
	@RequestMapping(value = "/home/login/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, HttpSession session, Model model) {

		
		return "changePassword";

	}
	
	@RequestMapping(value = "/home/login/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(HttpSession session, @ModelAttribute("form") @Valid ChangePasswordForm form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println("erro"+bindingResult.getAllErrors());
			return "changePassword";
		}
		if (form.getNewPassword().equalsIgnoreCase(form.getConfirmPassword())) {

			UserDTO dto = (UserDTO) session.getAttribute("user");
			dto = userServiceInt.findBypk(dto.getId());

			if (userServiceInt.changePassword(dto.getId(), form.getOldPassword(), form.getNewPassword())) {
				model.addAttribute("success", "Password changed Successfully");
			} else {
				model.addAttribute("error", "Old Passowors Does not Matched");
			}
		} else {
			model.addAttribute("error", "New Password and confirm password does not matched");
		}
		return "changePassword";
	}
	@RequestMapping(value = "/home/login/manager/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") ManagerForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/manager/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/home/login/manager";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserDTO dto = new UserDTO();
					dto.setId(id);
					userServiceInt.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		UserDTO dto = (UserDTO) form.getDTO();

		UserDTO uDto = (UserDTO) session.getAttribute("user");
		
		dto.setRoleId(2L);
		List<UserDTO> list = userServiceInt.search(dto, pageNo, pageSize);
		List<UserDTO> totallist = userServiceInt.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "userList";
	}
	
	//Edit Page show
	@GetMapping("/home/login/manager")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") ManagerForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			UserDTO bean = userServiceInt.findBypk(id);
			form.populate(bean);
		}
		return "approvePage";
	}
	//accept or reject manager
	@PostMapping("/home/login/manager")
	public String submit(@Valid @ModelAttribute("form") ManagerForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/manager";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "approvePage";
				}
				UserDTO bean = (UserDTO) populateDTO(form.getDTO(),request);
				bean.setRoleId(2L);
				bean.setRoleName("MANAGER");
				System.out.println("formmm" + form.getStatusApproval());
				System.out.println("Id "+bean.getId());
				if(form.getStatusApproval().equalsIgnoreCase("Accept")) {
				bean.setStatus("1");}
				else if(form.getStatusApproval().equalsIgnoreCase("Reject")) {
					System.out.println("******"+bean.getStatus());
					bean.setStatus("0");
				}
				if (bean.getId() > 0) {
					userServiceInt.update(bean);
					if(bean.getStatus().equalsIgnoreCase("1")) {
						model.addAttribute("success", "Manager is Approved!!!!");}
						else {
							model.addAttribute("success", "Manager is Rejected!!!!");
						}
					
				} else {
					userServiceInt.add(bean);
					model.addAttribute("success", "Manager Added Successfully!!!!");
				}
				return "approvePage";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "approvePage";
		}
		return "";
	}
	
	////////////////////////
	@RequestMapping(value = "/home/login/pilot/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") PilotForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		System.out.println("id id "+form.getId());
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/pilot/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/home/login/pilot";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserDTO dto = new UserDTO();
					dto.setId(id);
					System.out.println("id is "+id);
					userServiceInt.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		UserDTO dto = (UserDTO) form.getDTO();

		UserDTO uDto = (UserDTO) session.getAttribute("user");
		
		dto.setRoleId(3L);
		List<UserDTO> list = userServiceInt.search(dto, pageNo, pageSize);
		List<UserDTO> totallist = userServiceInt.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "pilotList";
	}
	
	//Edit Page show
	@GetMapping("/home/login/pilot")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") PilotForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			UserDTO bean = userServiceInt.findBypk(id);
			System.out.println("name"+bean.getFirstName());
			System.out.println("password"+bean.getPassword());
			form.populate(bean);
		}
		return "approvePilot";
	}
	//accept or reject pilot
	@PostMapping("/home/login/pilot")
	public String submit(@Valid @ModelAttribute("form") PilotForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		System.out.println("inside pilot");
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/pilot";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				System.out.println("hello");
				if (bindingResult.hasErrors()) {
					System.out.println("aa");
					System.out.println("****error****"+bindingResult.getAllErrors());
					return "approvePilot";
				}
				UserDTO bean = (UserDTO) populateDTO(form.getDTO(),request);
				System.out.println("beannnn"+bean.getPassword());
				UserDTO uDto=userServiceInt.findBypk(bean.getId());
				System.out.println("a");
				bean.setRoleId(3L);
				bean.setRoleName("PILOT");
				System.out.println("formmm" + form.getStatusApproval());
				System.out.println("Id "+bean.getId());
				if(form.getStatusApproval().equalsIgnoreCase("Accept")) {
				bean.setStatus("1");}
				else if(form.getStatusApproval().equalsIgnoreCase("Reject")) {
					System.out.println("******"+bean.getStatus());
					bean.setStatus("0");
				}
			/*
			 * bean.setEmployeeId(bean.getEmployeeId());
			 * bean.setPassword(bean.getPassword());
			 * bean.setSecretAns1(bean.getSecretAns1());
			 * bean.setSecretAns2(bean.getSecretAns2());
			 * bean.setSecretAns3(bean.getSecretAns3());
			 */
				
				if (bean.getId() > 0) {
					
					userServiceInt.update(bean);
					if(bean.getStatus().equalsIgnoreCase("1")) {
					model.addAttribute("success", "Pilot is Approved!!!!");}
					else {
						model.addAttribute("success", "Pilot is Rejected!!!!");
					}
				} else {
					userServiceInt.add(bean);
					model.addAttribute("success", "Pilot Added Successfully!!!!");
				}
				return "approvePilot";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "approvePilot";
		}
		return "";
	}
}
