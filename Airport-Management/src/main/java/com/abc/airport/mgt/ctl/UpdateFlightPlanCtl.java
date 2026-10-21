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

import com.abc.airport.mgt.dto.AllotHangerDTO;
import com.abc.airport.mgt.dto.DestinationLocDTO;
import com.abc.airport.mgt.dto.UpdateFlightPlanDTO;
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.AllotHangerForm;
import com.abc.airport.mgt.form.UpdateFlightPlanForm;
import com.abc.airport.mgt.service.DepartureLocServiceInt;
import com.abc.airport.mgt.service.DestinationLocServiceInt;
import com.abc.airport.mgt.service.PlaneServiceInt;
import com.abc.airport.mgt.service.UpdateFlightPlanServiceInt;
import com.abc.airport.mgt.service.UserServiceInt;
import com.abc.airport.mgt.service.WaypointsServiceInt;

@Controller
public class UpdateFlightPlanCtl extends BaseCtl {

	@Autowired
	private UpdateFlightPlanServiceInt service;
	@Autowired
	private PlaneServiceInt planeService;
	@Autowired
	private UserServiceInt userService;
	@Autowired
	private WaypointsServiceInt wayService;
	@Autowired
	private DepartureLocServiceInt depService;
	@Autowired
	private DestinationLocServiceInt desService;
	
	@ModelAttribute
	public void preload(Model model) {
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Available", "Available");
		map2.put("Alloted", "Alloted");
		model.addAttribute("h_status", map2);
		
		UserDTO uDto=new UserDTO();
		uDto.setRoleId(3L);
		model.addAttribute("userList",userService.search(uDto));
		model.addAttribute("planeList",planeService.search(null));
		model.addAttribute("wayList",wayService.search(null));
		model.addAttribute("depList",depService.search(null));
		model.addAttribute("desList",desService.search(null));
		
		
	}
	
	@GetMapping("/home/login/updateFlightPlan")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") UpdateFlightPlanForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			UpdateFlightPlanDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "updateFlightPlan";
	}
	
	@PostMapping("/home/login/updateFlightPlan")
	public String submit(@Valid @ModelAttribute("form") UpdateFlightPlanForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/updateFlightPlan";
		}
		
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				System.out.println("1. first");
			if (bindingResult.hasErrors()) {
				System.out.println("2. second");
				//model.addAttribute("error", bindingResult.getAllErrors());
				return "updateFlightPlan";
			}
			UpdateFlightPlanDTO bean = (UpdateFlightPlanDTO) populateDTO(form.getDTO(),request);
			UserDTO uDto=(UserDTO)session.getAttribute("user");
			System.out.println("*********id *******"+ uDto.getId());
			//UserDTO uDto=userService.findBypk();
			bean.setUserId(uDto.getId());
			//bean.setHanger(hangerService.findBypk(bean.getHangerId()));
			bean.setPlane(planeService.findBypk(bean.getPlaneId()));
			bean.setDesLoc(desService.findBypk(bean.getDestinationLocId()));
			bean.setWaypoints(wayService.findBypk(bean.getWaypointsId()));
			bean.setDepartureLocation(depService.findBypk(bean.getDepartureLocId()));
			//bean.setDestinationLocation(desService.findBypk(bean.getId()));
			UserDTO usDto=(UserDTO)session.getAttribute("user");
			try {
			if (bean.getId() > 0) {
				service.update(bean);
				model.addAttribute("success", "FLight plane update Successfully!!!!");
			} else {
				service.add(bean);
				model.addAttribute("success", "FLight Plan  Added Successfully!!!!");
			}
			return "updateFlightPlan";
		}
	 catch (DuplicateRecordException e) {
		model.addAttribute("error", e.getMessage());
		return "updateFlightPlan";
	}
}
		return "";}
	
	@RequestMapping(value = "/home/login/updateFlightPlan/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UpdateFlightPlanForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/updateFlightPlan/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/home/login/updateFlightPlan";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UpdateFlightPlanDTO dto = new UpdateFlightPlanDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		UpdateFlightPlanDTO dto = (UpdateFlightPlanDTO) form.getDTO();
		//DestinationLocDTO s = desService.findBypk(dto.getDestinationLocId());
		//dto.setDepartureLocation( s.getDestinationLoc());
		List<UpdateFlightPlanDTO> list = service.search(dto, pageNo, pageSize);
		List<UpdateFlightPlanDTO> totallist = service.search(dto);
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
		return "updateFlightPlanList";
	}
}
