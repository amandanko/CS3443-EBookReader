package model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EBookModel {
	
	private Path libraryPath;
	private List<Book> books;
	
	public EBookModel(){
		this.books = new ArrayList<Book>();
	}
	
	public void readAllBooks(){
		Iterator<Path> it = this.libraryPath.iterator();
		
		while( it.hasNext() ){
			System.out.println( it.next() );
		}
	}
	
	public void setPath( Path path ){
		this.libraryPath = path;
	}
	
}