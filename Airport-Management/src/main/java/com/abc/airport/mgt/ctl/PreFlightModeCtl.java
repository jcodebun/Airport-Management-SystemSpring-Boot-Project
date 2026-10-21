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

import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.dto.PreFlightModeDTO;
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.PlaneForm;
import com.abc.airport.mgt.form.PreFlightModeForm;
import com.abc.airport.mgt.service.PlaneServiceInt;
import com.abc.airport.mgt.service.PreFlightModeServiceInt;

@Controller
public class PreFlightModeCtl extends BaseCtl{

	@Autowired
	private PlaneServiceInt planeServiceInt;
	@Autowired
	private PreFlightModeServiceInt preServiceInt;
	
	
	@ModelAttribute
	public void preload(Model model) {
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("ON", "ON");
		map2.put("OFF", "OFF");		
		model.addAttribute("laptop_power", map2);
		
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("Full Charged", "Full Charged");
		map3.put("less than 50%", "less than 50%");		
		model.addAttribute("laptop_battery", map3);
		
		HashMap<String, String> map4 = new HashMap<String, String>();
		map4.put("Start", "Start");
		map4.put("Stop", "Stop");		
		model.addAttribute("mission", map4);
		
		HashMap<String, String> map5 = new HashMap<String, String>();
		map5.put("Secured", "Secured");
		map5.put("Damaged", "Damaged");		
		model.addAttribute("motor", map5);
		
		UserDTO uDto=new UserDTO();
		uDto.setRoleId(3L);
	//	model.addAttribute("pilotList",userService.search(uDto));
		model.addAttribute("planeList",planeServiceInt.search(null));
		//model.addAttribute("deslocList",desService.search(null));
		
	}
	
	@GetMapping("/home/login/flightlist")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") PreFlightModeForm form,
			HttpSession session, Model model) {
		System.out.println("****form*****"+form.getId());
		if (form.getId() > 0) {
			PreFlightModeDTO bean = preServiceInt.findBypk(id);
			form.populate(bean);
		}
		return "updatePreFlightCheckList";
	}
	
	@RequestMapping(value = "/home/login/flightlist/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") PreFlightModeForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/flightlist/search";
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
		PreFlightModeDTO dto = (PreFlightModeDTO) form.getDTO();

		//PlaneDTO uDto = (PlaneDTO) session.getAttribute("Plane");
		
		List<PreFlightModeDTO> list = preServiceInt.search(dto, pageNo, pageSize);
		List<PreFlightModeDTO> totallist = preServiceInt.search(dto);
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
		return "viewPreFlightModeList";
	}
	
	
	@PostMapping("/home/login/flightlist")
	public String submit(@Valid @ModelAttribute("form") PreFlightModeForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/flightlist";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "updatePreFlightCheckList";
				}
				PreFlightModeDTO bean = (PreFlightModeDTO) populateDTO(form.getDTO(),request);
				bean.setPlane(planeServiceInt.findBypk(bean.getPlaneId()));
				System.out.println("****id*********"+bean.getId());
				if (bean.getId() > 0) {
					preServiceInt.update(bean);
					model.addAttribute("success", "Check List update Successfully!!!!");
				} else {
					preServiceInt.add(bean);
					model.addAttribute("success", "Check list Added Successfully!!!!");
				}
				return "updatePreFlightCheckList";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "updatePreFlightCheckList";
		}
		return "";
	}
}
