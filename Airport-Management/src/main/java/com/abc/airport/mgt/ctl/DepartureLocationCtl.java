package com.abc.airport.mgt.ctl;

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

import com.abc.airport.mgt.dto.DepartureLocDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.DepartureLocForm;
import com.abc.airport.mgt.form.WaypointsForm;
import com.abc.airport.mgt.service.DepartureLocServiceInt;

@Controller
public class DepartureLocationCtl extends BaseCtl{

	@Autowired
	private DepartureLocServiceInt depService;
	@GetMapping(value = "/home/login/adddepartureloc")
	public String display(@ModelAttribute ("form") DepartureLocForm form,Model model) {
		return "departureLoc";
	}
	
	@PostMapping("/home/login/updatedeploc")
	public String submit(@Valid @ModelAttribute("form") DepartureLocForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/updatedeploc";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
					System.out.println("in heere");
				if (bindingResult.hasErrors()) {
					System.out.println("in here also");
					return "departureLoc";
				}
				DepartureLocDTO bean = (DepartureLocDTO) populateDTO(form.getDTO(),request);
				if (bean.getId() > 0) {
					//service.update(bean);
					model.addAttribute("success", "Departure Location update Successfully!!!!");
				} else {
					depService.add(bean);
					model.addAttribute("success", "Departure Location Added Successfully!!!!");
				}
				return "departureLoc";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "departureLoc";
		}
		return "";
	}
}
