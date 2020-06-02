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
/**
 * @return listResourcesPlanned
 */
protected PriorityQueue<RessourcesPlanned> getListResourcesPlanned() {
	return listResourcesPlanned;
}
/**
 * 
 * @return listAvailableResources
 */
protected List<Resource> getListAvailableResources() {
	return listAvailableResources;
}
/**
 *
 *@return dBranchTotalCost 
 */
protected double getdBranchTotalCost() {
	return dBranchTotalCost;
}
/**
 * 
 * @return dCurrentDate
 */
protected double getdCurrentDate() {
	return dCurrentDate;
}
/**
 * 
 * @param listAvailableResources
 */
protected void setListAvailableResources(List<Resource> listAvailableResources) {
	this.listAvailableResources = listAvailableResources;
}
/**
 * 
 * @param dBranchTotalCost
 */
protected void setdBranchTotalCost(double dBranchTotalCost) {
	this.dBranchTotalCost = dBranchTotalCost;
}
/**
 * 
 * @param dCurrentDate
 */
protected void setdCurrentDate(double dCurrentDate) {
	this.dCurrentDate = dCurrentDate;
}
/**
 * 
 * @param listResourcesPlanned
 */
protected void setListResourcesPlanned(PriorityQueue<RessourcesPlanned> listResourcesPlanned) {
	this.listResourcesPlanned = listResourcesPlanned;
}
/**
 * 
 * @return
 */
public double getdEndingDate() {
	return dEndingDate;
}
/**
 * 
 * @param dEndingDate
 */
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
