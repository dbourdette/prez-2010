package fr.prez.ioc;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class SampleBean {
	@PostConstruct
	public void sayHello() {
		System.out.println("Hi");
	}
}
