package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Book;

public class BookView extends JFrame{
	
	private Book book;

	public BookView( Book book ){
		super( book.getTitle() );
		this.book = book;
		
		JPanel bookDisplayPanel = new JPanel();
		bookDisplayPanel.setBackground( Color.MAGENTA );
		this.add( bookDisplayPanel );
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 600);
		this.setVisible(true);
	}
}
