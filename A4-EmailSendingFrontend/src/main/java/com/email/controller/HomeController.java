package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.email.model.Email;
import com.email.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute Email email, HttpSession session) {
		System.out.println(email);
		emailService.sendMail(email);
		session.setAttribute("msg", "Email Send Successfully");

		return "redirect:/";
	}

}
//[[${session.msg}]]
