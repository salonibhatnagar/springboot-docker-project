package com.myapp.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.usermanagement.entity.User;
import com.myapp.usermanagement.service.UserService;

@Controller
public class UserApp {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUser());
		return "list_users";
	}

	@GetMapping("/users/new")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "add_user";
	}

	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("/users/edit/{userId}")
	public String editUserForm(@PathVariable int userId, Model model) {
		model.addAttribute("user", userService.getUserById(userId));
		return "edit_user";
	}

	@PostMapping("/users/{userId}")
	public String updateUser(@PathVariable int userId, @ModelAttribute("user") User user, Model model) {
		User presentUser = userService.getUserById(userId);

		presentUser.setUserId(userId);
		presentUser.setFirstName(user.getFirstName());
		presentUser.setLastName(user.getLastName());
		presentUser.setUserEmail(user.getUserEmail());

		userService.updateUser(presentUser);
		return "redirect:/users";
	}

	@GetMapping("/users/delete/{userId}")
	public String deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
		return "redirect:/users";
	}
}
