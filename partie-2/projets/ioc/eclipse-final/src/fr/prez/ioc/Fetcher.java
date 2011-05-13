package fr.prez.ioc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.HtmlNode;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.TagNodeVisitor;
import org.springframework.stereotype.Component;

@Component
public class Fetcher {
	public String getText(String url) throws Exception {
		System.out.println("Fetching content on url " + url);
		
		HtmlCleaner cleaner = new HtmlCleaner();
		
		TagNode tagNode = cleaner.clean(new URL(url));
		
		return tagNode.getText().toString();
	}
	
	public List<String> getLinks(String url) throws Exception {
		final List<String> result = new ArrayList<String>();
		
		HtmlCleaner cleaner = new HtmlCleaner();
		
		TagNode tagNode = cleaner.clean(new URL(url));
		
		tagNode.traverse(new TagNodeVisitor() {
			
			@Override
			public boolean visit(TagNode tagNode, HtmlNode htmlNode) {
				if (htmlNode instanceof TagNode) {
		            TagNode tag = (TagNode) htmlNode;
		            String tagName = tag.getName();
		            if ("a".equals(tagName)) {
		                String href = tag.getAttributeByName("href");
		                if (href != null) {
		                	result.add(href);
		                }
		            }
		        }
				
		        return true;
			}
		});
		
		return result;
	}
}
