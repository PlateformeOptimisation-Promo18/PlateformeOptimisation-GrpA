package model.problem;

import java.util.List;
import java.util.PriorityQueue;

public class SharedEnvironementForPlanification {
List<Resource> listAvailableResources;
PriorityQueue<RessourcesPlanned> listResourcesPlanned;
protected double dBranchTotalCost=0.0;
protected double dCurrentDate=0.0;
protected double dEndingDate=0.0;

protected boolean bHaveBeenModified=false;

public SharedEnvironementForPlanification(List<Resource> listAvailableResources) {
	
}
public SharedEnvironementForPlanification(SharedEnvironementForPlanification envir) {
	
}
protected boolean isbHaveBeenModified() {
	//TODO 
return true;
	
}
protected boolean unsetbHaveBeenModified() {
	//TODO 
return true;
	
}
protected PriorityQueue<RessourcesPlanned> getListResourcesPlanned() {
	return listResourcesPlanned;
}
protected List<Resource> getListAvailableResources() {
	return listAvailableResources;
}
protected double getdBranchTotalCost() {
	return dBranchTotalCost;
}
protected double getdCurrentDate() {
	return dCurrentDate;
}
protected void setListAvailableResources(List<Resource> listAvailableResources) {
	this.listAvailableResources = listAvailableResources;
}
protected void setdBranchTotalCost(double dBranchTotalCost) {
	this.dBranchTotalCost = dBranchTotalCost;
}
protected void setdCurrentDate(double dCurrentDate) {
	this.dCurrentDate = dCurrentDate;
}
protected void setListResourcesPlanned(PriorityQueue<RessourcesPlanned> listResourcesPlanned) {
	this.listResourcesPlanned = listResourcesPlanned;
}
public double getdEndingDate() {
	return dEndingDate;
}
public void setdEndingDate(double dEndingDate) {
	this.dEndingDate = dEndingDate;
}
public void addBranchTotalCost(double dCost) {
	
}
public void updateEnvir() {
	
}
public void planResourceTask(Alternative alt,double dEndingDate) {
	
}




}
