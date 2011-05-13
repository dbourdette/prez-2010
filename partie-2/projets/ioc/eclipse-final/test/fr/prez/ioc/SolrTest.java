package fr.prez.ioc;

import java.util.Date;

import javax.inject.Inject;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring-context.xml")
public class SolrTest {
	@Inject
	private SolrServer solrServer;
	
	@Before
	public void clear() throws Exception {
		solrServer.deleteByQuery("*:*");
	}
	
	@Test
	public void addBean() throws Exception {
		WebDocument webDocument = new WebDocument();
		webDocument.setUrl("http://monsite.fr");
		webDocument.setLastModified(new Date());
		webDocument.setText("some text");
		
		solrServer.addBean(webDocument);
		solrServer.commit();
	}
	
	@Test
	public void query() throws Exception {
		addBean();
		
		SolrQuery query = new SolrQuery();
	    query.setQuery( "*:*" );
		
	    QueryResponse response = solrServer.query(query);
	    
	    Assert.assertEquals(1, response.getResults().size());
	    Assert.assertEquals("some text", response.getBeans(WebDocument.class).get(0).getText());
	}
}
