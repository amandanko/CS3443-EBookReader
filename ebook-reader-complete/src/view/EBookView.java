package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.EBookController;
import model.EBookModel;

public class EBookView extends JFrame {
	
	private EBookModel model;
	private JPanel mainPanel;
	private JButton libraryChooserButton;
	
	public EBookView( EBookModel m ){
		super( "CS 3443 EBook Reader" );
		this.model = m;
		
		this.mainPanel = new JPanel();
		mainPanel.setBackground( Color.BLUE );
		mainPanel.add( new JLabel("Welcome!") );
		this.libraryChooserButton = new JButton("Choose the location of your library");
		mainPanel.add( libraryChooserButton  );
		this.getContentPane().add( mainPanel );
	}

	public void registerListener(EBookController controller) {
		this.libraryChooserButton.addActionListener( controller );
	}

	
//	public static void main(String[] args) {
//		EBookView view = new EBookView( null );
//		
//		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		view.setSize(400, 600);
//		view.setVisible(true);
//	}
}
