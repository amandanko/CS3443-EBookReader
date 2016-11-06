package model;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EBookModel {
	
	private Path libraryPath;
	private List<Book> books;
	
	public EBookModel(){
		this.books = new ArrayList<Book>();
	}
	
	public void readInAllBooks(){
		// UPDATE: replaced Iterator implementation with something scalable..
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(this.libraryPath)) {
		    for (Path file: stream) {
		        System.out.println(file.getFileName());			// Print the file name, for debugging
		        Book newBook = readInBook( file );				// Try to read in the book info
		        if( newBook!=null )								//     if unsuccessful, don't add it to the library
		        	books.add( newBook );						//     if successful, add it to the library
		    }
		} catch (IOException | DirectoryIteratorException x) {
			// TODO: Do some exception handling here!
		    System.err.println(x);
		}
		
		System.out.println("My Library contains:");				// print library info for debugging
		System.out.println( books );
	}
	
	
	private Book readInBook( Path file ){
		if( file!=null && Files.exists( file ) ){
			String firstLineOfFile = null;
			
			try{
				Scanner in = new Scanner( file );		// Open the file for reading
				firstLineOfFile = in.nextLine();		// Read the first line of the file to a String
				in.close();								// Close the file!
			}catch(IOException ioe){
				System.out.println("Couldn't parse book: " + file);
				return null;
			}
			
			// return a new Book object, if the Book class is able to parse the info
			return Book.parse( firstLineOfFile, file );
		}
		return null;									// failed? return no books!
	}
	
	
	
	//////////////////////// GETTERS & SETTERS //////////////////////////////////
	public void setPath( Path path ){
		this.libraryPath = path;
	}
	
}