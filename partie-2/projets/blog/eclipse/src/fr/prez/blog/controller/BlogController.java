package fr.prez.blog.controller;

import javax.inject.Inject;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.prez.blog.service.PostService;

@Controller
public class BlogController {
	@Inject
	private PostService postService;
	
	@RequestMapping({"/", "index"})
	public String index(Model model) throws SolrServerException {
		model.addAttribute("posts", postService.index());
		
		return "index";
	}
	
	@RequestMapping("/{slug}")
	public String post(@PathVariable String slug, Model model) throws SolrServerException {
		model.addAttribute("post", postService.findBySlug(slug));
		
		return "post";
	}
}
