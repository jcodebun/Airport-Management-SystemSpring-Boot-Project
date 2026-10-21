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

import com.abc.airport.mgt.dto.DestinationLocDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.DepartureLocForm;
import com.abc.airport.mgt.form.DestinationLocForm;
import com.abc.airport.mgt.form.WaypointsForm;
import com.abc.airport.mgt.service.DestinationLocServiceInt;

@Controller
public class DestinationCtl extends BaseCtl{

	@Autowired
	private DestinationLocServiceInt desService;
	@GetMapping(value = "/home/login/adddestinationloc")
	public String display(@ModelAttribute ("form") DestinationLocForm form,Model model) {
		return "destinationLoc";
	}
	
	@PostMapping("/home/login/updatedesloc")
	public String submit(@Valid @ModelAttribute("form") DestinationLocForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/updatedesloc";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
					System.out.println("in heere");
				if (bindingResult.hasErrors()) {
					System.out.println("in here also");
					return "destinationLoc";
				}
				DestinationLocDTO bean = (DestinationLocDTO) populateDTO(form.getDTO(),request);
				if (bean.getId() > 0) {
					//service.update(bean);
					model.addAttribute("success", "Destination Location update Successfully!!!!");
				} else {
					desService.add(bean);
					model.addAttribute("success", "Destination Location Added Successfully!!!!");
				}
				return "destinationLoc";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "destinationLoc";
		}
		return "";
	}
}
