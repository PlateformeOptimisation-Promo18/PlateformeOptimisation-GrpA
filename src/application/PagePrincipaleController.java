package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

public class PagePrincipaleController 
{

	@FXML
	private Tab fenetreOptimisation;
	
	@FXML
	private Tab fenetreComparaison;
	
	@FXML
	private Tab fenetreConsultation;


	@FXML
	public void initialize ()
	{
		try
        {
        	fenetreConsultation.setContent(FXMLLoader.load(getClass().getResource("Demarage.fxml")));
        	
        	//a decommenter pour zied
        	//fenetreComparaison.setContent(FXMLLoader.load(getClass().getResource("Comparaison.fxml")));
        	
        	//a decommenter pour paul
        	//fenetreOptimisation.setContent(FXMLLoader.load(getClass().getResource("Optimisation.fxml")));
        	
        }
        catch(IOException iex)
        {
            System.out.println("unable to load OptimmisationTab");
        }
		
	}
	
	
	
}
