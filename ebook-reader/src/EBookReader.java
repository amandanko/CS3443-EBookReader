import javax.swing.JFrame;

import controller.EBookController;
import model.EBookModel;
import view.EBookView;

public class EBookReader {

	public static void main(String[] args) {
		
		EBookModel model = new EBookModel();
		EBookView view   = new EBookView(model);
		EBookController controller = new EBookController(model, view);
		
		// register controller as the listener to components in the view
		view.registerListener(controller);
		
		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
	}

}
