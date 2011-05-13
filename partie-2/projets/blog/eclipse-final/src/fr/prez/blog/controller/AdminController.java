package fr.prez.blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.prez.blog.domain.Post;
import fr.prez.blog.domain.TagsPropertyEditor;
import fr.prez.blog.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	public static final String SLUG_CHARS = "abcdefghijklmnopqrstuvwxyz_-";
	
	@Inject
	private PostService postService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, "tags", new TagsPropertyEditor());
	}
	
	@RequestMapping("/posts")
	public String list(Model model) throws SolrServerException {
		SolrQuery query = new SolrQuery(PostService.ALL_POSTS);
		query.addSortField("date", ORDER.desc);

		model.addAttribute("posts", postService.list(query));
		model.addAttribute("tags", postService.findTags());
		
		return "admin/posts/list";
	}
	
	@RequestMapping("/posts/editer")
	public String edit(Model model, String id) throws IOException, SolrServerException {
		if (id == null) {
			Post post = new Post();
			post.setId(UUID.randomUUID().toString());
			
			model.addAttribute("post", post);
		} else {
			model.addAttribute("post", postService.find(id));
		}
		
		model.addAttribute("tags", postService.findTags());
		
		return "admin/posts/edit";
	}
	
	@RequestMapping(value = "/posts/editer", method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid Post post, BindingResult result) throws IOException, SolrServerException {
		if (!StringUtils.containsOnly(post.getSlug(), SLUG_CHARS)) {
			result.rejectValue("slug", "slug.chars", "Le slug ne peut contenir que les éléments suivants : " + SLUG_CHARS);
		}
		
		if (result.hasErrors()) {
			return "admin/posts/edit";
		}
		
		postService.save(post);
		
		return "redirect:/admin/posts/editer?id=" + post.getId();
	}
	
	@RequestMapping(value = "/posts/supprimer")
	public String delete(String id) throws IOException, SolrServerException {
		postService.delete(id);
		
		return "redirect:/admin/posts";
	}
}
