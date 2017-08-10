package br.com.crud.servlet;

import org.apache.commons.lang.StringEscapeUtils;

public class RestResponse {
	String title;
	String message;

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public void setTitle(String title) {
		this.title = StringEscapeUtils.escapeHtml(title);
	}

	public void setMessage(String message) {
		this.message = StringEscapeUtils.escapeHtml(message);
	}
}
