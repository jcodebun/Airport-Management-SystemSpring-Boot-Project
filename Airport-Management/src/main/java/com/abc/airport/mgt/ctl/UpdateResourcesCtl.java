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

import com.abc.airport.mgt.dto.AddHangerDTO;
import com.abc.airport.mgt.dto.DepartureLocDTO;
import com.abc.airport.mgt.dto.DestinationLocDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.AddHangerForm;
import com.abc.airport.mgt.form.DepartureLocForm;
import com.abc.airport.mgt.form.DestinationLocForm;
import com.abc.airport.mgt.form.UserRegistrationForm;
import com.abc.airport.mgt.form.WaypointsForm;
import com.abc.airport.mgt.service.DepartureLocServiceInt;
import com.abc.airport.mgt.service.DestinationLocServiceInt;
import com.abc.airport.mgt.service.WaypointsServiceInt;

@Controller
public class UpdateResourcesCtl extends BaseCtl {
	
	@Autowired
	private WaypointsServiceInt service;
	@Autowired
	private DepartureLocServiceInt depService;
	@Autowired
	private DestinationLocServiceInt desService;

	
	@GetMapping(value = "/home/login/updateResources")
	public String display() {
		return "updateResource";
	}
	/*
	 * @PostMapping("/home/login/updatewaypoints") public String
	 * submit(@Valid @ModelAttribute("form") WaypointsForm form, BindingResult
	 * bindingResult, HttpSession session, Model model,HttpServletRequest request) {
	 * 
	 * if (OP_RESET.equalsIgnoreCase(form.getOperation())) { return
	 * "redirect:/home/login/updateResources"; }
	 * 
	 * try { if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
	 * 
	 * if (bindingResult.hasErrors()) { return "updateResource"; } WaypointsDTO bean
	 * = (WaypointsDTO) populateDTO(form.getDTO(),request); if (bean.getId() > 0) {
	 * //service.update(bean); model.addAttribute("success",
	 * "Waypoints update Successfully!!!!"); } else { service.add(bean);
	 * model.addAttribute("success", "Waypoints Added Successfully!!!!"); } return
	 * "updateResource"; } } catch (DuplicateRecordException e) {
	 * model.addAttribute("error", e.getMessage()); return "updateResource"; }
	 * return ""; }
	 * 
	 * @PostMapping("/home/login/updatedeploc") public String
	 * submit(@Valid @ModelAttribute("form2") DepartureLocForm
	 * form2,@ModelAttribute("form") WaypointsForm form, BindingResult
	 * bindingResult, HttpSession session, Model model,HttpServletRequest request) {
	 * 
	 * if (OP_RESET.equalsIgnoreCase(form2.getOperation())) { return
	 * "redirect:/home/login/updateResources"; }
	 * 
	 * try { if (OP_SAVE.equalsIgnoreCase(form2.getOperation())) {
	 * System.out.println("in heere"); if (bindingResult.hasErrors()) {
	 * System.out.println("in here also"); return "updateResource"; }
	 * DepartureLocDTO bean = (DepartureLocDTO) populateDTO(form2.getDTO(),request);
	 * if (bean.getId() > 0) { //service.update(bean); model.addAttribute("success",
	 * "Departure Location update Successfully!!!!"); } else { depService.add(bean);
	 * model.addAttribute("success", "Departure Location Added Successfully!!!!"); }
	 * return "updateResource"; } } catch (DuplicateRecordException e) {
	 * model.addAttribute("error", e.getMessage()); return "updateResource"; }
	 * return ""; }
	 * 
	 * @PostMapping("/home/login/updatedesloc") public String
	 * submit(@Valid @ModelAttribute("form2") DepartureLocForm
	 * form2,@ModelAttribute("form") WaypointsForm form,@ModelAttribute("form3")
	 * DestinationLocForm form3, BindingResult bindingResult, HttpSession session,
	 * Model model,HttpServletRequest request) {
	 * 
	 * if (OP_RESET.equalsIgnoreCase(form3.getOperation())) { return
	 * "redirect:/home/login/updateResources"; }
	 * 
	 * try { if (OP_SAVE.equalsIgnoreCase(form3.getOperation())) {
	 * System.out.println("in heere"); if (bindingResult.hasErrors()) {
	 * System.out.println("in here also"); return "updateResource"; }
	 * DestinationLocDTO bean = (DestinationLocDTO)
	 * populateDTO(form3.getDTO(),request); if (bean.getId() > 0) {
	 * //service.update(bean); model.addAttribute("success",
	 * "Destination Location update Successfully!!!!"); } else {
	 * desService.add(bean); model.addAttribute("success",
	 * "Destination Location Added Successfully!!!!"); } return "updateResource"; }
	 * } catch (DuplicateRecordException e) { model.addAttribute("error",
	 * e.getMessage()); return "updateResource"; } return ""; }
	 */
	
}
