package fr.prez.blog.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;

import fr.prez.blog.domain.Post;

@Service
public class PostService {
	
	public static final String ALL_POSTS = "*:*"; 
	
	@Inject
	private SolrServer solrServer;
	
	public void save(Post post) throws IOException, SolrServerException {
		solrServer.addBean(post);
		solrServer.commit();
	}
	
	public void delete(String id) throws IOException, SolrServerException {
		solrServer.deleteById(id);
		solrServer.commit();
	}
	
	public Post find(String id) throws SolrServerException {
		SolrQuery query = new SolrQuery(ALL_POSTS);
		query.addFilterQuery("id:" + id);
		
		return uniqueResult(list(query));
	}
	
	public Post findBySlug(String slug) throws SolrServerException {
		SolrQuery query = new SolrQuery(ALL_POSTS);
		query.addFilterQuery("slug:" + slug);
		
		return uniqueResult(list(query));
	}
	
	public List<Post> list(SolrQuery query) throws SolrServerException {
		return solrServer.query(query).getBeans(Post.class);
	}
	
	public List<Post> index() throws SolrServerException {
		SolrQuery query = new SolrQuery(ALL_POSTS);
		query.addSortField("date", ORDER.desc);
		query.setRows(5);
		
		return list(query);
	}
	
	private Post uniqueResult(List<Post> posts) {
		if (posts.size() == 0) {
			return null;
		}
		
		return posts.get(0);
	}
}
