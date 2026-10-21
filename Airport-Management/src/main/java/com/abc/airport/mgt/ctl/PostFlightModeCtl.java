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

import com.abc.airport.mgt.dto.AddHangerDTO;
import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.dto.PostFlightModeDTO;
import com.abc.airport.mgt.dto.PreFlightModeDTO;
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.PostFlightModeForm;

import com.abc.airport.mgt.service.AddHangerServiceInt;
import com.abc.airport.mgt.service.PlaneServiceInt;
import com.abc.airport.mgt.service.PostFlightModeServiceInt;
import com.abc.airport.mgt.service.PreFlightModeServiceInt;

@Controller
public class PostFlightModeCtl extends BaseCtl {

	@Autowired
	private PlaneServiceInt planeServiceInt;
	@Autowired
	private PostFlightModeServiceInt postServiceInt;
	@Autowired
	private AddHangerServiceInt hangerService;
	@ModelAttribute
	public void preload(Model model) {
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("ON", "ON");
		map2.put("OFF", "OFF");		
		model.addAttribute("masterSwitch", map2);
		
		
		
		UserDTO uDto=new UserDTO();
		uDto.setRoleId(3L);
	//	model.addAttribute("pilotList",userService.search(uDto));
		model.addAttribute("planeList",planeServiceInt.search(null));
		model.addAttribute("hangerList",hangerService.search(null));
		
	}
	
	@GetMapping("/home/login/postflightlist")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") PostFlightModeForm form,
			HttpSession session, Model model) {
		System.out.println("****form*****"+form.getId());
		if (form.getId() > 0) {
			PostFlightModeDTO bean = postServiceInt.findBypk(id);
			form.populate(bean);
		}
		return "updatePostFlightCheckList";
	}
	
	@RequestMapping(value = "/home/login/postflightlist/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") PostFlightModeForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/postflightlist/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/home/login/plane";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					PlaneDTO dto = new PlaneDTO();
					dto.setId(id);
					planeServiceInt.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		PostFlightModeDTO dto = (PostFlightModeDTO) form.getDTO();

		//PlaneDTO uDto = (PlaneDTO) session.getAttribute("Plane");
		
		List<PostFlightModeDTO> list = postServiceInt.search(dto, pageNo, pageSize);
		List<PostFlightModeDTO> totallist = postServiceInt.search(dto);
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
		return "viewPostFlightModeList";
	}
	
	
	@PostMapping("/home/login/postflightlist")
	public String submit(@Valid @ModelAttribute("form") PostFlightModeForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/postflightlist";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "updatePostFlightCheckList";
				}
				PostFlightModeDTO bean = (PostFlightModeDTO) populateDTO(form.getDTO(),request);
				bean.setPlane(planeServiceInt.findBypk(bean.getPlaneId()));
				bean.setHanger(hangerService.findBypk(bean.getHangerId()));
				System.out.println("****id*********"+bean.getId());
				if (bean.getId() > 0) {
					postServiceInt.update(bean);
					model.addAttribute("success", "Check List update Successfully!!!!");
				} else {
					postServiceInt.add(bean);
					model.addAttribute("success", "Check list Added Successfully!!!!");
				}
				return "updatePostFlightCheckList";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "updatePostFlightCheckList";
		}
		return "";
	}
}
