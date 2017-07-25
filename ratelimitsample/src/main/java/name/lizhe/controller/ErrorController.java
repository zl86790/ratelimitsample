package name.lizhe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("/myerrorjsp")
	public String errorJsp() {
		return "myerror";

	}

}