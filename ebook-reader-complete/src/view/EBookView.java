package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BookDisplayController;
import controller.EBookController;
import model.EBookModel;

public class EBookView extends JFrame {
	
	private EBookModel model;
	private JPanel mainPanel;
	private LibraryView libraryPanel;
	private JButton libraryChooserButton;
	
	public EBookView( EBookModel m ){
		super( "CS 3443 EBook Reader" );
		this.model = m;
		
		// Create the panel over the JFrame which we'll switch out
		this.mainPanel = new JPanel();
		mainPanel.setBackground( Color.WHITE );
		mainPanel.add( new JLabel("Welcome!") );
		
		// Add a button to the panel for the user to choose their library
		this.libraryChooserButton = new JButton("Choose the location of your library");
		mainPanel.add( libraryChooserButton  );
		
		// Add the main content panel to the JFrame to show to the user.
		this.getContentPane().add( mainPanel );
	}

	public void registerListener(EBookController controller) {
		this.libraryChooserButton.addActionListener( controller );
	}
	
	public void displayBooks(){
		// Switch to the library view (displays the listing of books to user)
		libraryPanel = new LibraryView( model );			// initialize the JPanel to display in the frame
		this.getContentPane().remove( mainPanel );			// clear our the current view
		this.getContentPane().add( libraryPanel );			// update the view with the library panel
		revalidate();										// rebalance the project - needed!
		repaint();											// repaint what is displayed to the user

		BookDisplayController controller = new BookDisplayController( model );
		libraryPanel.registerListener(controller);
	}

	
	public static void main(String[] args) {
		EBookView view = new EBookView( null );
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(450, 600);
		view.setVisible(true);
	}
}
