package fr.prez.ioc;

import java.util.Date;

import javax.inject.Inject;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.springframework.stereotype.Component;

@Component
public class Crawler {
	@Inject
	private Fetcher fetcher;
	
	@Inject
	private SolrServer solrServer;
	
	public void crawl(String url) throws Exception {
		WebDocument doc = new WebDocument();
		doc.setUrl(url);
		doc.setLastModified(new Date());
		doc.setText(fetcher.getText(url));
		
		solrServer.addBean(doc);
		solrServer.commit();
		
		// faire une pause de 50 ms
		Thread.sleep(50);
		
		for (String link : fetcher.getLinks(url)) {
			if (link.startsWith("http://")) {
				if (link.endsWith("/")) {
					link = link.substring(0, link.length() - 1);
				}
				
				if (!isInIndex(link)) {
					crawl(link);
				}
			}
		}
	}
	
	public boolean isInIndex(String url) throws Exception {
		SolrQuery query = new SolrQuery("url:" + ClientUtils.escapeQueryChars(url));
		
		return solrServer.query(query).getResults().getNumFound() != 0;
	}
}
