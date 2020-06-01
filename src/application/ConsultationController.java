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
		visualisationChart.getXAxis().setLabel("Hypervolum");//put x label of the chart
		visualisationChart.getYAxis().setLabel("Time");  //put y label of the chart
		visualisationChart.setTitle("Visualisation");//put the name of the chart

		//creation of a series of points to put on the chart
		XYChart.Series<Number,Number> series = new XYChart.Series<>();
		
		
		FileChooser fc = new FileChooser() ;//create a dialog-box that permits to choose a file from the computer
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));//only accept ext files
		File selectedFile = fc.showOpenDialog(null) ;//open file chooser

		try (   //objects that would be closed after the try bloc:
				FileReader filereader = new FileReader(selectedFile.getPath());
				BufferedReader bufferedreader = new BufferedReader(filereader) ) 
		{
			String ligne;

			ligne = bufferedreader.readLine();//skip the titles line
			
			while ((ligne = bufferedreader.readLine()) != null) //while there is something to read
			{
				 
				double x = Double.parseDouble(ligne.substring(14,21)); //all the times values takes 7 characters
				double y = Double.parseDouble(ligne.substring(0,13));//all the hyper-volumes values takes  14 characters
				series.getData().add(new XYChart.Data<Number,Number>(x,y));
			}
			
			visualisationChart.getData().add(series);//put values on the chart
			
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
