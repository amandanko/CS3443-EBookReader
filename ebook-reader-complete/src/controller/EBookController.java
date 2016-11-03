package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.JFileChooser;

import model.EBookModel;
import view.EBookView;

public class EBookController implements ActionListener{

	EBookModel model;
	EBookView view;
	
	public EBookController( EBookModel m, EBookView v ){
		this.model = m;
		this.view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Path p = getFileOrDirectoryPath();
		this.model.setPath(p);
		this.model.readAllBooks();
	}
	
	
	
	
	/**
     * allow user to specify file or directory name
     * (copied from JFileChooserDemo.java)
     * 
     * @return
     */
    private Path getFileOrDirectoryPath() {
        // configure dialog allowing selection of a file or directory
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this.view);

        // if user clicked Cancel button on dialog, return
        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        // return Path representing the selected file
        return fileChooser.getSelectedFile().toPath();
    }
	
}
