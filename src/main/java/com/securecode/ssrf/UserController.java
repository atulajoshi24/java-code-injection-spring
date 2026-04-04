package com.securecode.ssrf;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
	@GetMapping("/exploit")
    public String exploit(@RequestHeader(value = "Injected-Header", defaultValue = "Guest") String header, Model model) {
        // We pass the user-controlled header directly to the template
        model.addAttribute("userInput", header);
        return "vulnerable_template";
    }
	
	@GetMapping("/safe")
    public String safe(@RequestHeader(value = "Injected-Header", defaultValue = "Guest") String header, Model model) {
        // We pass the user-controlled header directly to the template
        model.addAttribute("userInput", header);
        return "safe_template";
    }

}
