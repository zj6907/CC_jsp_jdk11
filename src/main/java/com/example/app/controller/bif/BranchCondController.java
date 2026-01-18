package com.example.app.controller.bif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.service.bif.BranchCondService;

@Controller
@RequestMapping("/branchCond")
public class BranchCondController {

	@Autowired
	private BranchCondService service;
	
	@GetMapping
	public String showPage(Model model) {
		model.addAttribute("f", service.getForm());
		return "bif/branchCond";
	}

}
