package fr.prez.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static final void main(String[] args) throws Exception {
		String location = "fr/prez/ioc/spring-context.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(location);
		
		context.getBean(Crawler.class).crawl("http://www.rtl.fr");
	}
}
