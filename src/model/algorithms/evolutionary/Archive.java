package model.algorithms.evolutionary;

import java.util.List;

import model.generic.Problem;
import utils.InterfaceRandom;

public class Archive extends Population {


	public Archive(int iSize) {
		super(iSize);
		// TODO Auto-generated constructor stub
	}

	public void updateArchive(Population population, int iArchiveSize, Problem pb) {
		
	}
	
	private List<Individual> getSet(){
		return null;
		
	}
	
	private void miseAjourDistancePop(Problem pb, Population populationTemp) {
		
	}
	
	public void enleveDoublons(){
		
	}
	
	public void selection(Population population, InterfaceRandom generator, int iPopSize, int iNumkVoisin) {
		
	}
	
    public Population selectionParents(int nombreParent){
        // TODO :
        return null;
    }

    public void SelectionArchive(Population population){
        // TODO :
    }

}
