package fr.prez.ioc;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring-context.xml")
public class FetcherTest {
	@Inject
	private Fetcher fetcher;
	
	@Test
	public void getText() throws Exception {
		fetcher.getText("http://www.rtl.fr");
	}
	
	@Test
	public void getLinks() throws Exception {
		System.out.println(fetcher.getLinks("http://www.rtl.fr"));
	}
}
