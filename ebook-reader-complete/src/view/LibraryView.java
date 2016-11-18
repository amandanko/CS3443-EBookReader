package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BookDisplayController;
import controller.EBookController;
import model.Book;
import model.EBookModel;

public class LibraryView extends JPanel{
	
	private EBookModel model;
	private ArrayList<JButton> bookButtons;
	
	public LibraryView( EBookModel m ){
		super();
		this.model = m;
		
		this.add( new JLabel("My Library") );
		this.setBackground( Color.BLUE );
		
		this.bookButtons = new ArrayList<JButton>();
		Iterator<Book> bookIterator = model.getBooks();
		while( bookIterator.hasNext() ){
			Book b = bookIterator.next();
			JButton jb = new JButton( b.toString() );
			this.bookButtons.add( jb );
		}
		
		for( JButton b : bookButtons )
			this.add( b );
	}
	
	public void registerListener(BookDisplayController controller) {
		for( JButton b : bookButtons )
			b.addActionListener( controller );
	}
	
	public static void main(String[] args) {
		LibraryView viewPanel = new LibraryView( null );
		JFrame testFrame = new JFrame();
		
		testFrame.add( viewPanel );
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setSize(450, 600);
		testFrame.setVisible(true);
	}

}
