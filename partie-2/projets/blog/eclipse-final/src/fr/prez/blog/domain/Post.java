package fr.prez.blog.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.solr.client.solrj.beans.Field;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Post {
	@Field
	@NotNull
	private String id;
	
	@Field
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@NotNull
	private Date date;
	
	@Field
	@NotEmpty
	@Size(max = 255)
	private String slug;
	
	@Field
	@NotEmpty
	@Size(max = 50)
	private String author;
	
	@Field
	@NotEmpty
	@Size(max = 255)
	private String title;
	
	@Field
	@Size(max = 10000)
	private String text;
	
	@Field
	private List<String> tags;
	
	@Field
	private int commentCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
}
