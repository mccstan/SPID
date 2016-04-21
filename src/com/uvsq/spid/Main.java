package com.uvsq.spid;
	
import java.io.IOException;

import com.uvsq.spid.view.FilesOverviewController;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		try {
			// Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/FilesOverview.fxml"));
            rootLayout = (BorderPane) loader.load();
			
            FilesOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
			Scene scene = new Scene(rootLayout);
			
			
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean showShareDialog() {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("view/ShareForm.fxml"));
	            BorderPane page = (BorderPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Edit Person");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
	            dialogStage.setScene(scene);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	
	
	public static void main(String[] args) {
		launch(args);
	}
}
