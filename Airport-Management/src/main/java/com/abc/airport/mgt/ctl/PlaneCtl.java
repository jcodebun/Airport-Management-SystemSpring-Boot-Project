package com.abc.airport.mgt.ctl;

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
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.form.ManagerForm;
import com.abc.airport.mgt.form.PlaneForm;
import com.abc.airport.mgt.service.PlaneServiceInt;
import com.abc.airport.mgt.service.UserServiceInt;








@Controller
public class PlaneCtl extends BaseCtl {
	@Autowired
	private PlaneServiceInt planeServiceInt;
	
	@GetMapping("/home/login/plane")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") PlaneForm form,
			HttpSession session, Model model) {
		System.out.println("****form*****"+form.getId());
		if (form.getId() > 0) {
			PlaneDTO bean = planeServiceInt.findBypk(id);
			form.populate(bean);
		}
		return "plane";
	}
	@PostMapping("/home/login/plane")
	public String submit(@Valid @ModelAttribute("form") PlaneForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/plane";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "plane";
				}
				PlaneDTO bean = (PlaneDTO) populateDTO(form.getDTO(),request);
				System.out.println("****id*********"+bean.getId());
				if (bean.getId() > 0) {
					planeServiceInt.update(bean);
					model.addAttribute("success", "Plane update Successfully!!!!");
				} else {
					planeServiceInt.add(bean);
					model.addAttribute("success", "Plane Added Successfully!!!!");
				}
				return "plane";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "plane";
		}
		return "";
	}
	
	@RequestMapping(value = "/home/login/plane/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") PlaneForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/plane/search";
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
		PlaneDTO dto = (PlaneDTO) form.getDTO();

		PlaneDTO uDto = (PlaneDTO) session.getAttribute("Plane");
		
		List<PlaneDTO> list = planeServiceInt.search(dto, pageNo, pageSize);
		List<PlaneDTO> totallist = planeServiceInt.search(dto);
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
		return "planeList";
	}
	
	//Edit Page show
	/*
	 * @GetMapping("/home/login/plane") public String
	 * displayEdit(@RequestParam(required = false) Long id, Long
	 * pId, @ModelAttribute("form") PlaneForm form, HttpSession session, Model
	 * model) { if (form.getId() > 0) { PlaneDTO bean =
	 * planeServiceInt.findBypk(id); form.populate(bean); } return "plane"; }
	 */
}
