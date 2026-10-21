package com.abc.airport.mgt.ctl;

import java.util.HashMap;
import java.util.List;

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

import com.abc.airport.mgt.dto.AddWorkScheduleDTO;
import com.abc.airport.mgt.dto.AllotHangerDTO;
import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.dto.UpdateFlightPlanDTO;
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.AddWorkScheduleForm;
import com.abc.airport.mgt.form.AllotHangerForm;
import com.abc.airport.mgt.form.PlaneForm;
import com.abc.airport.mgt.form.UpdateFlightPlanForm;
import com.abc.airport.mgt.service.AddWorkScheduleServiceInt;
import com.abc.airport.mgt.service.DestinationLocServiceInt;
import com.abc.airport.mgt.service.UserServiceInt;

@Controller
public class AddWorkScheduleCtl extends BaseCtl {
	@Autowired
	private AddWorkScheduleServiceInt service;
	@Autowired
	private UserServiceInt userService;
	@Autowired
	private DestinationLocServiceInt desService;
	@ModelAttribute
	public void preload(Model model) {
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("09:00-10:00", "09:00-10:00");
		map2.put("10:00-11:00", "10:00-11:00");
		map2.put("11:00-12:00", "11:00-12:00");
		map2.put("12:00-13:00", "12:00-13:00");
		map2.put("13:00-14:00", "13:00-14:00");
		map2.put("14:00-15:00", "14:00-15:00");
		map2.put("15:00-16:00", "15:00-16:00");
		model.addAttribute("time_stat", map2);
		
		UserDTO uDto=new UserDTO();
		uDto.setRoleId(3L);
		model.addAttribute("pilotList",userService.search(uDto));
		//model.addAttribute("planeList",planeService.search(null));
		model.addAttribute("deslocList",desService.search(null));
		
	}

	@GetMapping("/home/login/workschedule")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") AddWorkScheduleForm form,
			HttpSession session, Model model) {
		
		  if (form.getId() > 0) { AddWorkScheduleDTO bean = service.findBypk(id);
		  form.populate(bean); }
		 
		return "addWorkSchedule";
	}
	@PostMapping("/home/login/workschedule")
	public String submit(@Valid @ModelAttribute("form") AddWorkScheduleForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/workschedule";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					System.out.println(bindingResult.getAllErrors());
					return "addWorkSchedule";
				}
				AddWorkScheduleDTO bean = (AddWorkScheduleDTO) populateDTO(form.getDTO(),request);
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				bean.setPilot(userService.findBypk(bean.getPilotId()));
				bean.setPilotId(bean.getPilotId());
				bean.setDesLoc(desService.findBypk(bean.getDestinationLocationId()));
				//bean.setDestinationLocation(desService.findBypk(form.getDestinationLocation()));
				
				System.out.println("****id*********"+bean.getId());
				
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Time schedule update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Time schedule Added Successfully!!!!");
				}
				return "addWorkSchedule";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "addWorkSchedule";
		}
		return "";
	}
	
	@RequestMapping(value = "/home/login/viewWorkSchedule/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") AddWorkScheduleForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/viewWorkSchedule/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/home/login/workschedule";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					AddWorkScheduleDTO dto = new AddWorkScheduleDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		
		
		AddWorkScheduleDTO dto = (AddWorkScheduleDTO) form.getDTO();
		UserDTO uDto=(UserDTO)session.getAttribute("user");
		if(uDto.getRoleId()==3) {
			dto.setPilotId(uDto.getId());
		}
		//DestinationLocDTO s = desService.findBypk(dto.getDestinationLocId());
		//dto.setDepartureLocation( s.getDestinationLoc());
		List<AddWorkScheduleDTO> list = service.search(dto, pageNo, pageSize);
		List<AddWorkScheduleDTO> totallist = service.search(dto);
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
		return "viewWorkSchedule";
	}
}
