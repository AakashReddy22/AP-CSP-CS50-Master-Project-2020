package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.util.BeanLookup;
import com.vaadin.flow.router.Route;


@SpringBootApplication(scanBasePackages = {"com.example"})
@Route(value = "VaadinUI", layout = VaadinUI.class)
public class DemoApplication {


	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
		
		
	
	}

}

