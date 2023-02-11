package br.com.ifms.lp2.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test {
	@GetMapping("/menssagem")
	public String message() {
		return "Hello Word!!!";
	}
}

