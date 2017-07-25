package name.lizhe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	@RequestMapping("/ratelimit/test")
	public String test() {
		System.out.println("test...");
		return "accessed test";
	}

}