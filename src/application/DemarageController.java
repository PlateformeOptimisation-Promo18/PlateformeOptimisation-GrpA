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

/**
 * Controller for the beginning Page that open at start
 * @author INES LEGROS
 */
public class DemarageController 
{
	@FXML
	private Button boutonDemarrage;

	/**
	 * Open the main page on button click
	 * @param evt event when we click on the button
	 * @author INES LEGROS
	 */
	@FXML
	public void boutonDemarrageClick(ActionEvent evt)
	{
		try
		{
			Stage stage = (Stage) boutonDemarrage.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("PagePrincipale.fxml"));
			Scene scene = new Scene(root,800,800);
			stage.getIcons().setAll(new Image(getClass().getResource("optimisation.png").toExternalForm()));
			stage.setTitle("Plateforme d'optimisation");
			stage.setScene(scene);
			stage.show();//show the main page
		}
		catch(Exception e)
		{
			Logger logger = Logger.getLogger("logger");
			logger.log(Level.INFO, e.getMessage());
		}
		
	}
}
