package view;

import javax.swing.JFrame;

import controller.EBookController;
import model.EBookModel;

public class EBookView extends JFrame {
	
	private EBookModel model;
	
	public EBookView( EBookModel m ){
		super( "CS 3443 EBook Reader" );
		this.model = m;
	}

	public void registerListener(EBookController controller) {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String[] args) {
		EBookView view = new EBookView( null );
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 600);
		view.setVisible(true);
	}
}
