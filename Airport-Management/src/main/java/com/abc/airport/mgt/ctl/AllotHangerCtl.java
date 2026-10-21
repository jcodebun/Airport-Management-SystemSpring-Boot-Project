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
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.AllotHangerForm;
import com.abc.airport.mgt.service.AddHangerServiceInt;
import com.abc.airport.mgt.service.AllotHangerServiceInt;
import com.abc.airport.mgt.service.PlaneServiceInt;
import com.abc.airport.mgt.service.UserServiceInt;




@Controller
public class AllotHangerCtl extends BaseCtl {

	@Autowired
	private AllotHangerServiceInt service;
	@Autowired
	private UserServiceInt userService;
	@Autowired
	private AddHangerServiceInt hangerService;
	@Autowired
	private PlaneServiceInt planeService;
	
	@ModelAttribute
	public void preload(Model model) {
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Available", "Available");
		map2.put("Alloted", "Alloted");
		model.addAttribute("h_status", map2);
		
		UserDTO uDto=new UserDTO();
		uDto.setRoleId(2L);
		//model.addAttribute("managerList",userService.search(uDto));
		model.addAttribute("planeList",planeService.search(null));
		model.addAttribute("hangerList",hangerService.search(null));
		
	}
	
	@GetMapping("/home/login/allothanger")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") AllotHangerForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			AllotHangerDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "allotHanger";
	}

	@PostMapping("/home/login/allothanger")
	public String submit(@Valid @ModelAttribute("form") AllotHangerForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/allothanger";
		}
		
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				System.out.println("1. first");
			if (bindingResult.hasErrors()) {
				System.out.println("2. second");
			//	model.addAttribute("error", bindingResult.getAllErrors());
				return "allotHanger";
			}
			AllotHangerDTO bean = (AllotHangerDTO) populateDTO(form.getDTO(),request);
			UserDTO uDto=(UserDTO)session.getAttribute("user");
			System.out.println("*********id *******"+ uDto.getId());
			//UserDTO uDto=userService.findBypk();
			bean.setManager(uDto);
			bean.setManager_id(uDto.getId());
			bean.setHanger(hangerService.findBypk(bean.getHangerId()));
			bean.setPlane(planeService.findBypk(bean.getPlaneId()));
			UserDTO usDto=(UserDTO)session.getAttribute("user");
			if (bean.getId() > 0) {
				if(bean.getStatus().equalsIgnoreCase("Alloted")) {
					System.out.println("in here ***");
				service.update(bean);
				model.addAttribute("success", "Hanger allot to Plane Updated Successfully!!!!");
				return "updateAllotHangerStatus";}else if(bean.getStatus().equalsIgnoreCase("Available")) {
					System.out.println("in here "+bean.getId());
					bean.setId(bean.getId());
					service.deleteById(bean.getId());
					model.addAttribute("success", "Plane removed from hanger!!!!");
					return "updateAllotHangerStatus";
				}
			} else {
				try {
					service.add(bean);
					model.addAttribute("success", "Hanger allot to Plane Added Successfully!!!!");
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					model.addAttribute("error", e.getMessage());
					return "allotHanger";
				}
				
			}
			return "allotHanger";
		}
	/*} catch (DuplicateRecordException e) {
		model.addAttribute("error", e.getMessage());
		return "addHanger";
	}*/
		return "";
	}

	@RequestMapping(value = "/home/login/allothanger/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") AllotHangerForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/allothanger/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/home/login/allothanger";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					AllotHangerDTO dto = new AllotHangerDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		AllotHangerDTO dto = (AllotHangerDTO) form.getDTO();

		
		List<AllotHangerDTO> list = service.search(dto, pageNo, pageSize);
		List<AllotHangerDTO> totallist = service.search(dto);
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
		return "allotHangerList";
	}
	
	//display
	@GetMapping("/home/login/allothanger/edit")
	public String displayEditStatus(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") AllotHangerForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			AllotHangerDTO bean = service.findBypk(id);
			System.out.println("here");
			form.populate(bean);
		}
		return "updateAllotHangerStatus";
	}
}
