package com.biz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		// return "users/join"
		return "join";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "user/login";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage() {

		// InternalView를 사용한 rendering
		return "user/mypage";
	}

}
