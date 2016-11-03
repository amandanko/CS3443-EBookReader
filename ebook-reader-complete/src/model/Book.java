package model;

public class Book {

	private String title;
	private String author;
	private String fullFileName;
	
	public Book( String title, String author, String fullFileName ){
		this.title  = title;
		this.author = author;
		this.fullFileName = fullFileName;
	}
	
	
	

	///////// GETTERS & SETTERS ////////////
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFullFileName() {
		return fullFileName;
	}

	public void setFullFileName(String fullFileName) {
		this.fullFileName = fullFileName;
	}
}