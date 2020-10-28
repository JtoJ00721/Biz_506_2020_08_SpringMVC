package com.biz.ems.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ems.model.EmsVO;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "ems-write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
//	public String write(String from_email, String to_email, String s_subject, Model model) {
	public String write(@ModelAttribute EmsVO emsVO, Model model) {

		model.addAttribute("from_email", emsVO.getFrom_email());
		model.addAttribute("to_email", emsVO.getTo_email());
		model.addAttribute("s_subject", emsVO.getS_subject());

		model.addAttribute("EMS", emsVO);

		return "ems-view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id) {
		return "ems-write";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update() {
		return "ems-view";
	}

	public String delete(String id) {
		return "redirect:/";
	}

}
