package model;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Book class maintains general info about books in the user's library.
 * 		This class currently works well reading in .txt files from Gutenberg Press.
 * 
 * 
 * @author Amanda Danko
 */
public class Book implements Comparable<Book>{

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
	 *  ParseBookInfo method takes the 1st line of a Gutenberg press .txt file 
	 *  and parses the book title and author from it.
	 *  
	 *   	Example:
	 *   		Project Gutenberg's The Adventures of Sherlock Holmes, by Arthur Conan Doyle
	 * 
	 * @param firstLineOfGutenbergFile String text from first line of file
	 * @param file Path to book .txt file
	 * @return new Book object
	 */
	public static Book parseBookInfo( String firstLineOfGutenbergFile, Path file ){
		String title  = "";
		String author = "";
		
		if( firstLineOfGutenbergFile!=null && firstLineOfGutenbergFile.length()>25 ){
			// trim out the "Project Gutenberg's "
			firstLineOfGutenbergFile = firstLineOfGutenbergFile.substring(20);
			String[] info = firstLineOfGutenbergFile.split(", by ");
			if( info!=null & info.length>=2 ){
				title  = info[0];
				author = info[1];
			}
		}
		
		return new Book( title, author, file );
	}
	
	
	public static void main(String[] args){
		Book book1 = new Book( "Java For Developers", "Smith", null );
		Book book2 = new Book( "Java For Developers", "Jones", null );
		Book book3 = new Book( "Atlas Shrugged", "Ayn Rand", null );
		
		Book[] books = new Book[3];
		books[0] = book1;
		books[1] = book2;
		books[2] = book3;
		
		// Choose one of the following lines of code to sort your library!
//		Arrays.sort( books );							// Comparable
		Arrays.sort( books, Book.BookComparator ); 		// Comparator
		
		for( Book b : books ){
			System.out.println( b );
		}
	}
	
	@Override
	public int compareTo(Book o) {
		return this.getTitle().compareTo(o.getTitle());   //pass the buck! Call String's compareTo method.
	}
	
	public static Comparator<Book> BookComparator = new Comparator<Book>() {

		public int compare(Book book1, Book book2) {
			int titleScore = book1.getTitle().compareTo(book2.getTitle());
			int authorScore = book1.getAuthor().compareTo(book2.getAuthor());
			
			return titleScore + authorScore;
		}
	};
	

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