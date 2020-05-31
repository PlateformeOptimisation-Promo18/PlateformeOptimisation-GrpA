package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DemarageController 
{
	@FXML
	private Button boutonDemarrage;

	@FXML
	private void boutonDemarrageClick(ActionEvent evt) throws Exception
	{
		
		 Stage stage;
	     Parent root;
	     
	     stage = (Stage) boutonDemarrage.getScene().getWindow();
	     
	     root = FXMLLoader.load(getClass().getResource("PagePrincipale.fxml"));
	     
	     Scene scene = new Scene(root,800,800);
	     stage.getIcons().setAll(new Image(getClass().getResource("optimisation.png").toExternalForm()));
	     stage.setScene(scene);
	     stage.show();
		
	}
}
