package fr.prez.blog.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Item;

import fr.prez.blog.domain.Post;
import fr.prez.blog.service.PostService;

@Controller
public class BlogController {
	@Inject
	private PostService postService;

	@RequestMapping({ "/", "index" })
	public String index(Model model) throws SolrServerException {
		model.addAttribute("posts", postService.index());
		model.addAttribute("tags", postService.findTags());

		return "index";
	}
	
	@RequestMapping("index.json")
	@ResponseBody
	public List<Post> indexJson(Model model) throws SolrServerException {
		return postService.index();
	}

	@RequestMapping("/{slug}")
	public String post(@PathVariable String slug, Model model)
			throws SolrServerException {
		model.addAttribute("post", postService.findBySlug(slug));
		model.addAttribute("tags", postService.findTags());

		return "post";
	}

	@RequestMapping("/recherche")
	public String search(String query, String tag, Model model) throws SolrServerException {
		model.addAttribute("query", query);
		model.addAttribute("posts", postService.search(query, tag));
		model.addAttribute("tags", postService.findTags());

		return "search";
	}

	@RequestMapping("/rss")
	@ResponseBody
	public Channel rss() throws SolrServerException {
		Channel channel = new Channel();
		
		channel.setFeedType("rss_2.0");
		channel.setTitle("Mon flux rss");
		channel.setDescription("Description");
		channel.setLink("http://localhost:8080/rss");

		for (Post post : postService.index()) {
			Item item = new Item();
			
			item.setTitle(post.getTitle());
			item.setLink("http://localhost:8080/" + post.getId());
			item.setAuthor(post.getAuthor());
			item.setPubDate(post.getDate());
			
			channel.getItems().add(item);
		}
		
		return channel;
	}
}
