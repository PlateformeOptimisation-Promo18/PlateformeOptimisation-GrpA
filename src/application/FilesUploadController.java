package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.rmi.server.LoaderHandler;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FilesUploadController implements Initializable{
	
	ArrayList<double[]> resultat1 ;
	String nomPb1 = "" ;
	ArrayList<double[]> resultat2 ;
	String nomPb2 = "" ;
	
	String pathFichier1 ;
	String pathFichier2 ;
	
	@FXML
	private Button fichier1;
	
	@FXML
	private Button fichier2;
	
	@FXML
	private Button btnComparer;
	
	@FXML
	private ListView<String> listeFichiers;
	
	/**
	 * Fonction pour permettre l'upload du fichier resultat1
	 * @param event
	 */
	@FXML
	public void uploadFichier1(ActionEvent event) {
		try {
			FileChooser fichier1 = new FileChooser() ;
			// ajout de filtre 
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fichier1.getExtensionFilters().add(extFilter);
			
			File selectedFile = fichier1.showOpenDialog(null) ;
			
			
			
			if ( selectedFile != null) {
				listeFichiers.getItems().add(selectedFile.getName());
				pathFichier1 = selectedFile.getAbsolutePath();
				nomPb1 = selectedFile.getName();
				verifMemeProbleme();
			} else {
				System.out.println("Erreur lors de l'upload du fichier 1");
			}		
		} catch (Exception e) {
		      e.printStackTrace();
		}
	}
	
	/**
	 * Fonction pour permettre l'upload du fichier resultat2
	 * @param event
	 */
	@FXML
	public void uploadFichier2(ActionEvent event) {
		
		try {
			FileChooser fichier2 = new FileChooser() ;
			// ajout de filtre 
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fichier2.getExtensionFilters().add(extFilter);
			
			File selectedFile = fichier2.showOpenDialog(null) ;			
			
			if ( selectedFile != null) {
				listeFichiers.getItems().add(selectedFile.getName());
				pathFichier2 = selectedFile.getAbsolutePath();
				nomPb2 = selectedFile.getName();
				verifMemeProbleme();
			} else {
				System.out.println("Erreur lors de l'upload du fichier 2");
			}
		} catch (Exception e) {
		      e.printStackTrace();
		}
	}
	
	/**
	 * Ouvre le document du résultat et met les valeurs dans une arrayList de doubles
	 * @param pathFichier
	 * @return
	 */
	private ArrayList<double[]> getResultsFromFile(String pathFichier) {
		
		// arrayList contenant les couples de doubles (hypervolum,Time) dans un double[2] 
		ArrayList<double[]> resultat = new  ArrayList<double[]>() ;
		 
		int compteur = 0;
		BufferedReader bufferedreader = null;
		FileReader filereader = null;
	    try {
	      // On ouvre le fichier
	      filereader = new FileReader(pathFichier);
	      bufferedreader = new BufferedReader(filereader);
	      // String qui va contenir la ligne à chaque itération
	      String ligne;
	      double hyperVolum;
	      double time ;
	      // Tant qu'il ya des ligne
	      while ((ligne = bufferedreader.readLine()) != null) {
	        if (compteur > 0) {
	   		 	double[] point = new double[2] ;
	   		 	// 6 chifres avant et apres la virgule
		        hyperVolum = Double.parseDouble(ligne.substring(0,13)) ;
		        
	   		 	// 5 chifres apres la virgule
		        time = Double.parseDouble(ligne.substring(14,21)) ;
		        point[0] = hyperVolum ;
		        point[1] = time ;
		        resultat.add(point);
	        }
	        compteur++;
	      }
	      
	      return resultat;
	      
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally { // a la fin on ferme le bufferedReader et le fileReader
	      try {
	        if (bufferedreader != null)
	          bufferedreader.close();
	        if (filereader != null)
	          filereader.close();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
		
		return null;
	}
	
	public void verifMemeProbleme() { 
		if (nomPb1.isEmpty() || nomPb2.isEmpty()) {
			btnComparer.setDisable(true);
		} else if (nomPb1.substring(0,nomPb1.indexOf('_')).equals(nomPb2.substring(0,nomPb2.indexOf('_')))) {
			btnComparer.setDisable(false);
		} else {
			btnComparer.setDisable(true);
		}
	}
	
	/**
	 * Ouvre la page du comparateur et appelle la méthode comparer 
	 * du comparateurController
	 * @param event
	 */
	@FXML
	public void runComparateur(ActionEvent event) {
		
		try {
			// On appelle la fonction getResultsFromFile en lui passant le chemin du fichier
			resultat1 = getResultsFromFile(pathFichier1) ;
			
			// On appelle la fonction getResultsFromFile en lui passant le chemin du fichier
			resultat2 = getResultsFromFile(pathFichier2) ;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../application/Comparateur.fxml")) ;
			Parent root = (Parent) loader.load();
			ComparateurController compController = loader.getController();	
			
			compController.comparer(resultat1,nomPb1, resultat2, nomPb2);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		btnComparer.setDisable(true);
	}
	
}
