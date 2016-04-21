package com.uvsq.spid.view;

import com.uvsq.spid.Main;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class FilesOverviewController {
    @FXML
    private TableView<String> filesTable;
    
    //Ref to main app
    private Main mainApp;
    
    @FXML
    private void handleShareFile(){
    	mainApp.showShareDialog();
    }
    
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
		
	}
}
