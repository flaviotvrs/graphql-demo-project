package br.com.flaviotvrs.tutorial.entrypoint.model;

public class BookResponseModel {

	private String id;
	private String name;
	private Integer pageCount;
	private Integer authorId;
	private String published;
	private String isbn10;
	private String isbn13;

	public BookResponseModel(String id, String name, Integer pageCount, Integer authorId, String published,
			String isbn10, String isbn13) {
		super();
		this.id = id;
		this.name = name;
		this.pageCount = pageCount;
		this.authorId = authorId;
		this.published = published;
		this.isbn10 = isbn10;
		this.isbn13 = isbn13;
	}

	public BookResponseModel() {
		super();
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

	public String getPublished() {
		return published;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public String getIsbn13() {
		return isbn13;
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

	public void setPublished(String published) {
		this.published = published;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

}
