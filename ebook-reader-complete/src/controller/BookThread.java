package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Book;
import view.BookView;

public class BookThread extends Thread{
	
	private Book book;

	@Override
	public void run() {
		// your code here! 
		
		BookView bView = new BookView( book );
	}
	
	public void setRequestedBook( Book b ){
		this.book = b;
	}
	
	public static void main( String[] args ){
		BookThread bv1 = new BookThread();
		bv1.start();
	}
}
