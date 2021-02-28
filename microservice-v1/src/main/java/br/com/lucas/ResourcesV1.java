package br.com.lucas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesV1 {
	
	
	@GetMapping(value = "/cart")
	private ResponseEntity<String> getCart() {
		return new ResponseEntity<>("{\"version\":\"v1\", \"path\":\"/cart\"}", HttpStatus.OK);
	}
	
	@GetMapping(value = "/checkout")
	private ResponseEntity<String> getCheckout() {
		return new ResponseEntity<>("{\"version\":\"v1\", \"path\":\"/checkout\"}", HttpStatus.OK);
	}
}
