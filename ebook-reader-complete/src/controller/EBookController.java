package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.JFileChooser;

import model.EBookModel;
import view.EBookView;

public class EBookController implements ActionListener{

	private EBookModel model;				// Model for the overall application
	private EBookView view;					// View for the overall application
	
	public EBookController( EBookModel m, EBookView v ){
		this.model = m;
		this.view = v;
	}

	/**
	 * User has clicked the only button on the main screen - choose a library directory.
	 * Ask the model to read in files from the directory they choose & set up their library of books.
	 * If successful, update the view to display their new library.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Path p = getFileOrDirectoryPath();				// Get path chosen by user
		this.model.setPath(p);							// Update the model
		this.model.readInAllBooks();					// Ask model to update data in this application
		this.view.displayBooks();						// Update the view
	}
	
	
	
	
	/**
     * Allow user to specify a directory name (copied from JFileChooserDemo.java)
     * 
     * @return Path to the chosen directory
     */
    private Path getFileOrDirectoryPath() {
        // configure dialog allowing selection of a file or directory
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(this.view);

        // if user clicked Cancel button on dialog, return
        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        // return Path representing the selected file
        return fileChooser.getSelectedFile().toPath();
    }
}