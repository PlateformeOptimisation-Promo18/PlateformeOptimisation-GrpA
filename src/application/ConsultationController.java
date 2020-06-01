package application;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
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
	private LineChart<Number, Number>  visualisationChart;
	
	@FXML
	private void boutonUploadClick (ActionEvent evt)
	{		


		// Name axes
		visualisationChart.getXAxis().setLabel("Hypervolum");
		visualisationChart.getYAxis().setLabel("Time");  
		visualisationChart.setTitle("Visualisation");

		// Definion des series
		XYChart.Series series = new XYChart.Series();
		
		FileChooser fc = new FileChooser() ;
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
		File selectedFile = fc.showOpenDialog(null) ;
		
		try 
		{
			
			if ( selectedFile != null) 
			{
				FileReader filereader = new FileReader(selectedFile.getPath());
				BufferedReader bufferedreader = new BufferedReader(filereader);

				String ligne;
				int compteur = 0;
				
				while ((ligne = bufferedreader.readLine()) != null) 
				{
					if (compteur > 0) 
					{
						series.getData().add(new XYChart.Data(Double.parseDouble(ligne.substring(14,21)),Double.parseDouble(ligne.substring(0,13)) ));
						
					}
					
					compteur++;
				}
				visualisationChart.getData().add(series);
			}	
		} catch (Exception e) {
			e.printStackTrace();
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
