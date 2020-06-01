package application;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DemarageController 
{
	@FXML
	private Button boutonDemarrage;

	@FXML
	private void boutonDemarrageClick(ActionEvent evt)
	{
		try
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
		catch(Exception e)
		{
			Logger logger = Logger.getLogger("logger");
			logger.log(Level.INFO, e.getMessage());
		}
		
	}
}
