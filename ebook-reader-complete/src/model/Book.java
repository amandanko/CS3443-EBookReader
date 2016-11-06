package model;

import java.nio.file.Path;

public class Book {

	private String title;				// title of the book
	private String author;				// author(s) of the book
	private Path fullFilePath;			// full path to book file
	private int bookmark;				// last known page #
	private boolean hasRead;			// whether the user has read it already
	
	public Book( String title, String author, Path fullFileName ){
		this.title  = title;
		this.author = author;
		this.fullFilePath = fullFileName;
	}
	
	/**
	 * 
	 *   Example:
	 *   Project Gutenberg's The Adventures of Sherlock Holmes, by Arthur Conan Doyle
	 * 
	 * @param firstLineOfGutenbergFile
	 * @param file
	 * @return
	 */
	public static Book parse( String firstLineOfGutenbergFile, Path file ){
		String title  = "";
		String author = "";
		
		if( firstLineOfGutenbergFile!=null && firstLineOfGutenbergFile.length()>25 ){
			// trim out the "Project Gutenberg's "
			firstLineOfGutenbergFile = firstLineOfGutenbergFile.substring(20);
			String[] info = firstLineOfGutenbergFile.split(", by ");
			title  = info[0];
			author = info[1];
		}
		
		return new Book( title, author, file );
	}
	

	public String toString(){
		return "\"" + title + "\" by " + author;
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

	public Path getFullFilePath() {
		return fullFilePath;
	}

	public void setFullFilePath(Path fullFileName) {
		this.fullFilePath = fullFileName;
	}
}