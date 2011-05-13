package fr.prez.ioc;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Search {
	public static final void main(String[] args) throws Exception {
		String location = "fr/prez/ioc/spring-context.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(location);
		
		SolrQuery query = new SolrQuery("sarkozy");
		
		QueryResponse response = context.getBean(SolrServer.class).query(query);
		
		System.out.println("Found " + response.getResults().getNumFound() + " documents");
		
		for (WebDocument doc : response.getBeans(WebDocument.class)) {
			System.out.println(doc.getUrl());
		}
	}
}
