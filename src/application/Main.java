package application;
	
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) {
		try
		{
			BorderPane root = FXMLLoader.load(getClass().getResource("Demarage.fxml"));
			Scene scene = new Scene(root,500,500);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.getIcons().setAll(new Image(getClass().getResource("optimisation.png").toExternalForm()));
			primaryStage.setTitle("Plateforme d'optimisation");
			primaryStage.show();//show start-up screen
		} 
		catch(Exception e) 
		{
			Logger logger = Logger.getLogger("logger");
			logger.log(Level.INFO, e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
