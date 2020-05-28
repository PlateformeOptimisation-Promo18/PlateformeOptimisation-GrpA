package application;

import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
 
 
public class ComparateurController {
 
	// LineChart de javaFx sur lequel on affiche les courbes 
    @FXML 
    private LineChart<Number, Number> lineChart ; 
	
	 /**
	  * Affiche les courbes des deux solution sur la LineChart
	  * @param Solution1 : arayList qui contient des tableau de double de taille 2
	  * contenant l'hypervolum et le Time 
	  * @param Solution2 : arayList qui contient des tableau de double de taille 2
	  * contenant l'hypervolum et le Time 
	  */
     public void comparer(ArrayList<double[]> Solution1, String nameSol1 , ArrayList<double[]> Solution2 , String nameSol2) {
        try {
	    	 // Definion des axes 
			NumberAxis axis;
	
			// On gère les limites de l'axe X pour un affichage clair
			axis=(NumberAxis) lineChart.getXAxis();
			axis.setAutoRanging(false);
			// Valeur min de l'axe : l'hypervolum min des deux solution 
			axis.setLowerBound(Solution1.get(0)[0] <= Solution2.get(0)[0]?Solution1.get(0)[0]:Solution2.get(0)[0]);		
			
			// Valeur max de l'axe : l'hypervolum max des deux solution 
			axis.setUpperBound(Solution1.get(Solution1.size()-1)[0] <= Solution2.get(Solution2.size()-1)[0]?Solution1.get(Solution1.size()-1)[0]:Solution2.get(Solution2.size()-1)[0]);
	    	
			// On nomme les axes
	        lineChart.getXAxis().setLabel("Hypervolum");
	        lineChart.getYAxis().setLabel("Time");
	
	        // Creation du chart    
	        lineChart.setTitle("Comparaison des Solution ");
	        
	        // Definion des series
	        XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
	        series1.setName(nameSol1);
	        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
	        series2.setName(nameSol2);
	        
	        // On ajoute les données aux series
	        for (double[] point : Solution1) {
	        	series1.getData().add(new XYChart.Data<Number, Number>(point[0], point[1]));
	        }
	        
	        for (double[] point : Solution2) {
	        	series2.getData().add(new XYChart.Data<Number, Number>(point[0], point[1]));
	        }
	        
	        // On ajoute les séries
	        lineChart.getData().add(series1);
	        lineChart.getData().add(series2);
        } catch (Exception e) {
  	      e.printStackTrace();
  	    }

     }
}
 
