package com.gama.function.impl;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class WelcomeFunction implements Function<String, String> {

	@Override
	public String apply(String t) {
		
		return "Welcome " + t;
	}

}
