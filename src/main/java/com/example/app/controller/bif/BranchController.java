package com.example.app.controller.bif;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.form.bif.BranchCondForm;
import com.example.domain.model.bif.BranchInfoView;
import com.example.domain.service.bif.BranchService;
import com.example.domain.validator.bif.BranchCondFormValidator;

@Controller
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchCondFormValidator validator;

	@Autowired
	private BranchService service;

	@PostMapping
	public String showPage(@ModelAttribute("f") BranchCondForm f, @RequestParam("action") String action, BindingResult br, Model model) {
		validator.validate(action, f, br);
		if (br.hasErrors()) {
			return "bif/branchCond";
		}
		List<BranchInfoView> list = service.execute(action, f);
		model.addAttribute("list", list);
		return "bif/branch";
	}

}
