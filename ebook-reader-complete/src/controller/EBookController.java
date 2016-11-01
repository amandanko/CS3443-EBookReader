package controller;

import model.EBookModel;
import view.EBookView;

public class EBookController {

	EBookModel model;
	EBookView view;
	
	public EBookController( EBookModel m, EBookView v ){
		this.model = m;
		this.view = v;
	}
	
}
