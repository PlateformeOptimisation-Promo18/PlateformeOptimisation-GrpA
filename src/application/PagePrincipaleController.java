package application;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

/**
 * Controller for the main Page that permit to choose your tab
 * @author INES LEGROS
 */
public class PagePrincipaleController 
{

	@FXML
	private Tab fenetreOptimisation;
	
	@FXML
	private Tab fenetreComparaison;
	
	@FXML
	private Tab fenetreConsultation;

	
	/**
	 * initialize all the tab (Consultation Comparison and Optimization)
	 * @author INES LEGROS
	 */
	@FXML
	public void initialize ()
	{
		try
        {
			//put Consultation screen on consultation's tab
        	fenetreConsultation.setContent(FXMLLoader.load(getClass().getResource("Consultation.fxml")));
        	
        	//put Comparison screen on Comparison's tab
        	fenetreComparaison.setContent(FXMLLoader.load(getClass().getResource("FilesUpload.fxml")));
        	
        	//put Optimization screen on Optimization's tab
        	//fenetreOptimisation.setContent(FXMLLoader.load(getClass().getResource("Optimisation.fxml")));
        	
        }
        catch(Exception e)
        {
			Logger logger = Logger.getLogger("logger");
			logger.log(Level.INFO, e.getMessage());
        }
		
	}
	
	
	
}
