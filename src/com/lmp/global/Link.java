package com.lmp.global;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Link")
public class Link {
	private String action;
	private String url;
	private String method;
	private String rel;
	
	public Link() {}
	
	public Link(String action, String url) {
		this.action = action;
		this.url = url;
	}
	
	public Link(String action, String url,String method) {
		this.action = action;
		this.url = url;
		this.method= method;
	}
	
	public Link(String action, String url,String method,String rel) {
		this.action = action;
		this.url = url;
		this.method= method;
		this.rel=rel;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	
}
