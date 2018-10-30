package org.eop.ssm.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lixinjie
 * @since 2018-10-30
 */
@RequestMapping("/example")
@Controller
public class ExampleController {

	@RequestMapping("/index")
	public String index() {
		return "example/index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "example/login";
	}
	
	@RequestMapping("/success")
	public String success() {
		return "example/success";
	}
	
	@RequestMapping("/failure")
	public String failure() {
		return "example/failure";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "example/logout";
	}
}