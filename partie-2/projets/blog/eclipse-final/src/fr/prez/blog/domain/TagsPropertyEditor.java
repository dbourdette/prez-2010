package fr.prez.blog.domain;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class TagsPropertyEditor extends PropertyEditorSupport {

	@SuppressWarnings("unchecked")
	@Override
	public String getAsText() {
		List<String> tags = (List<String>) getValue();
		
		return StringUtils.join(tags, ",");
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		List<String> tags = Arrays.asList(StringUtils.split(text, ","));
		
		setValue(tags);
	}

}
