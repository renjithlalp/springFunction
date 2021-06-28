package com.gama.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.gama.function.beans.Employee;



@SpringBootApplication
public class SpringFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFunctionApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	     return builder.build();
	}
	
	@Bean
	public Function<String, String> function(){
		return x -> "Hello " + x;
	}
	
	@Bean
    public Supplier<String> supply(){
		return () -> "Hello Welcome to the world of Spring cloud function ";
	}
    
	@Bean
    public Consumer<String> consume(){
		return x -> System.out.println("Hello " + x);
	}
	
	@Bean
    public Consumer<Employee> persist(){
		return x -> System.out.println("Hello " + x.getEmpName());
	}

}
