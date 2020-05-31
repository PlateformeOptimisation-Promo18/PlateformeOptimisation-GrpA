package application;

import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ConsultationController 
{
	
	@FXML
	private Button boutonUpload;
	
	@FXML
	private LineChart visualisationChart;
	
	@FXML
	private void boutonUploadClick (ActionEvent evt)
	{		
		Stage primaryStage = (Stage) boutonUpload.getScene().getWindow();
		
		final FileChooser fileChooser = new FileChooser();
		
		File file = fileChooser.showOpenDialog(primaryStage);
		
		try {
			Scanner SC = new Scanner(file);

            while (SC.hasNextDouble()) 
            {
            	Double x = SC.nextDouble();
            	Double y = SC.nextDouble();
				visualisationChart.getData().add(new XYChart.Data(x, y));
            }
            SC.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}

	@FXML
	public void initialize ()
	{
		Image uploadImage=new Image(getClass().getResource("upload.png").toExternalForm());
		ImageView imageView=new ImageView(uploadImage);
		imageView.setFitHeight(50);
		imageView.setFitWidth(50);
		boutonUpload.setGraphic(imageView);
	}
}
