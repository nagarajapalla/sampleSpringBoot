package com.nts.firstMicroService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hi")
// @Validated
public class Demo {

	@RequestMapping(method = RequestMethod.GET)
	String sayHello(@PathVariable("say1") String say1) {
		if (say1 != null)
			return say1;
		return "Hello";
	}

	@GetMapping("/emp")
	ResponseEntity<?> sayHi(@RequestParam(value = "empId", required = true) @Valid @NotNull Integer empId) {
		// Assert.notNull(empId, "empId required");

		Object response = null;

		if (Objects.isNull(empId)) {
			List<String> errorMessages = Arrays.asList("empId is null");
			response = Response.builder().status("ERROR").statusMessages(errorMessages).build();
			return ResponseEntity.badRequest().body(response);
		}
		response = empId;

		return ResponseEntity.badRequest().body(empId);

	}

	@PostMapping("/emp")
	ResponseEntity<?> createEmp(@Valid @RequestBody Emp emp, Errors errors) {
		// Assert.notNull(empId, "empId required");

		Object response = null;
		// If error, just return a 400 bad request, along with the error message
		if (errors.hasErrors()) {

			// get all errors
			List<String> errorMsgs = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.toList());
			response = Response.builder().status("ERROR").statusMessages(errorMsgs).build();

			return ResponseEntity.badRequest()
					.body(response);

		}

		return ResponseEntity.ok().body(emp);

	}

}
