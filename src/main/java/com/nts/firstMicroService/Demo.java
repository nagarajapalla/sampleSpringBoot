package com.nts.firstMicroService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hi")
@Validated
public class Demo {
	
	@RequestMapping(method=RequestMethod.GET)
	String sayHello(@PathVariable("say1") String say1){
		if (say1 != null ) return say1;
		return "Hello";
	}
	
	@GetMapping("/emp")
	Integer sayHi(@RequestParam(value="empId",required=true) @Valid @NotNull Integer empId){
		//Assert.notNull(empId, "empId required");
		return empId;
	}

}
