package fr.prez.ioc;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class WebDocument {
	@Field
    private String url;

    @Field("last_modified")
    private Date lastModified;

    @Field
    private String text;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
