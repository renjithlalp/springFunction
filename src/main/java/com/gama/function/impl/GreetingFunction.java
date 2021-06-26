package com.gama.function.impl;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.gama.function.beans.Employee;

@Component
public class GreetingFunction implements Function<Employee, String> {

	@Override
	public String apply(Employee t) {		
		return "Hi " + t.getEmpName();
	}

}
