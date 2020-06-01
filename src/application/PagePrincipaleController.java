package application;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        	fenetreConsultation.setContent(FXMLLoader.load(getClass().getResource("Consultation.fxml")));
        	
        	//a decommenter pour zied
        	//fenetreComparaison.setContent(FXMLLoader.load(getClass().getResource("Comparaison.fxml")));
        	
        	//a decommenter pour paul
        	//fenetreOptimisation.setContent(FXMLLoader.load(getClass().getResource("Optimisation.fxml")));
        	
        }
        catch(Exception e)
        {
			Logger logger = Logger.getLogger("logger");
			logger.log(Level.INFO, e.getMessage());
        }
		
	}
	
	
	
}
