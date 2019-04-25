package br.com.flaviotvrs.tutorial.entrypoint.model;

public class BookResponseModel {

	private String id;
	private String name;
	private Integer pageCount;
	private Integer authorId;

	public BookResponseModel() {
	}

	public BookResponseModel(String id, String name, Integer pageCount, Integer authorId) {
		this();
		this.id = id;
		this.name = name;
		this.pageCount = pageCount;
		this.authorId = authorId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

}
