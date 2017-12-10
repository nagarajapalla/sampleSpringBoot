package com.nts.firstMicroService;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Emp {
	
	@NotNull(message = "EMP name should not be null")
	private String name;
	@NotNull
	private Integer age;

}
