package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.EBookModel;
import view.EBookView;

public class BookDisplayController implements ActionListener{
	
	private EBookModel model;				// Model for the overall application
	private EBookView view;					// View for the overall application

	public BookDisplayController(EBookModel model2) {
		this.model = model2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton)e.getSource();
		String requestedTitle = jb.getText();
		System.out.println( requestedTitle );
		
		BookThread bt = new BookThread();
		bt.setRequestedBook( model.getBook(requestedTitle) );
		bt.start();
	}

}
