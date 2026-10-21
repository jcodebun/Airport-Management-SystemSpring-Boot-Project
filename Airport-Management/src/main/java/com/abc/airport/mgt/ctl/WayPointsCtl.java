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

import com.abc.airport.mgt.dto.WaypointsDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.DepartureLocForm;
import com.abc.airport.mgt.form.DestinationLocForm;
import com.abc.airport.mgt.form.WaypointsForm;
import com.abc.airport.mgt.service.WaypointsServiceInt;

@Controller
public class WayPointsCtl extends BaseCtl {
	
	@Autowired
	private WaypointsServiceInt service;
	@GetMapping(value = "/home/login/addwaypoints")
	public String display(@ModelAttribute ("form") WaypointsForm form,Model model) {
		return "waypoints";
	}
	@PostMapping("/home/login/updatewaypoints")
	public String submit(@Valid @ModelAttribute("form") WaypointsForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/updateResources";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "waypoints";
				}
				WaypointsDTO bean = (WaypointsDTO) populateDTO(form.getDTO(),request);
				if (bean.getId() > 0) {
					//service.update(bean);
					model.addAttribute("success", "Waypoints update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Waypoints Added Successfully!!!!");
				}
				return "waypoints";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "waypoints";
		}
		return "";
	}
}
