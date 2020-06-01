package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ConsultationController 
{
	
	@FXML
	private Button boutonUpload;
	
	@FXML
	private LineChart<Number, Number>  visualisationChart;
	
	@FXML
	private void boutonUploadClick (ActionEvent evt)
	{		
		// Name axes
		visualisationChart.getXAxis().setLabel("Hypervolum");
		visualisationChart.getYAxis().setLabel("Time");  
		visualisationChart.setTitle("Visualisation");

		// Definion des series
		XYChart.Series<Number,Number> series = new XYChart.Series<>();
		
		
		FileChooser fc = new FileChooser() ;
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
		File selectedFile = fc.showOpenDialog(null) ;

		try (
				FileReader filereader = new FileReader(selectedFile.getPath());
				BufferedReader bufferedreader = new BufferedReader(filereader) ) {
			String ligne;
			int compteur = 0;

			while ((ligne = bufferedreader.readLine()) != null) 
			{
				if (compteur > 0) 
				{
					double x = Double.parseDouble(ligne.substring(14,21));
					double y = Double.parseDouble(ligne.substring(0,13));
					series.getData().add(new XYChart.Data<Number,Number>(x,y));
				}

				compteur++;
			}
			visualisationChart.getData().add(series);

		} catch (Exception e) {
			Logger logger = Logger.getLogger("logger");
			logger.log(Level.INFO, e.getMessage());
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
