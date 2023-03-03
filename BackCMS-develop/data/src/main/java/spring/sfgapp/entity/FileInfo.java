package spring.sfgapp.entity;

import org.springframework.web.util.UriComponents;

public class FileInfo {
	private String name;
	private String url;

	public FileInfo(String name, UriComponents url) {
		this.name = name;
		this.url = String.valueOf(url);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
//https://www.bezkoder.com/spring-boot-file-upload/