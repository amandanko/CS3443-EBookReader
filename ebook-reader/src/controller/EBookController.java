package controller;

import model.EBookModel;
import view.EBookView;

public class EBookController {

	private EBookModel model;
	private EBookView view;
	
	public EBookController( EBookModel m, EBookView v ){
		this.model = m;
		this.view = v;
	}
	
}
