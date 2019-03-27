package br.com.focusnetworks.WebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.focusnetworks.WebApp.model.Login;
import br.com.focusnetworks.WebApp.repository.LoginRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

	public LoginController(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	@GetMapping
	public String index(@ModelAttribute("login") Login login, Model model) {
		model.addAttribute("login", new Login());
		return "login/index";
	}

	@PostMapping("/confirm")
	public String confirm(@ModelAttribute("login") Login login, Model model) {

		if (login.getUsername().length() > 0 && login.getEmail().length() > 0 && login.getPassword().length() > 0) {

			model.addAttribute("username", login.getUsername());
			model.addAttribute("email", login.getEmail());
			model.addAttribute("password", login.getPassword());

			return "login/confirm";
		}
		return "login/error";
	}

	@PostMapping("/")
	public String create(@ModelAttribute("login") Login login, Model model) {
		this.loginRepository.save(login);
		return "redirect:/login/success";
	}

	@GetMapping("/success")
	public String success(@ModelAttribute("login") Login login, Model model) {
		model.addAttribute("login", new Login());
		return "login/success";
	}

	@GetMapping("/error")
	public String error(@ModelAttribute("login") Login login, Model model) {
		model.addAttribute("login", new Login());
		return "login/error";
	}

}
