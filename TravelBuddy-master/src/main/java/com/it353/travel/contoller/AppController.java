package com.it353.travel.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.it353.travel.entity.User;
import com.it353.travel.model.CustomUserDetails;
import com.it353.travel.repository.UserRepository;

@Controller
public class AppController {
	@GetMapping({"", "projectIndex"})
	public String viewHomePage() {
	return "projectIndex";
	}

	@GetMapping("destinations")
    public String viewDestinationsPage() {
    return "destinations";
    }
	
	@GetMapping("about")
    public String viewAboutPage() {
    return "about";
    }
	
	@GetMapping("random")
    public String viewRandomPage() {
    return "random";
    }
	
	@GetMapping("Contact")
    public String viewContactPage() {
    return "Contact";
	}
    
	@GetMapping("info")
    public String viewInfoPage() {
    return "info";
    }
	
	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
	model.addAttribute("user", new User());

	return "signup_form.html";
	}
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/process_register")
	public String processRegister(User user) {

	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userRepo.save(user);

	return "register_success";
	}
	@GetMapping("/users")
	public String listUsers(Model model, Authentication authentication) {
	 
	Object principal = authentication.getPrincipal();
	        String fullName = ((CustomUserDetails) principal).getFullName();
	        model.addAttribute("fullName", fullName); 
	        List<User> listUsers = userRepo.findAll();//it is going to find all users
	        model.addAttribute("listUsers", listUsers);
	        
	        return "projectIndex";
	}

	}
