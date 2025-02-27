package interfaces;

import classes.*;

public interface I_EmergencyDispatchCenter {
	
	public List<FireStation> getFireStations();
	
	public void setFireStations(List<FireStation> fireStations);
	
	public List<Emergency> getEmergencies();
	
	public void setEmergencies(List<Emergency> emergencies);
	
	public boolean addFireStation (FireStation station);
	
	public Emergency newCall (String location, EmergencyKinds kind, int patients, int patientsDoc);
	
	public boolean addCalltoList (Emergency call);
	
	public boolean dispatchVehicles ();

	public void sortCalls ();
	
	public void sortVehicles ();
	
	public void printRespondingVehicles (Emergency call);
	
	public boolean addVehicle (int station, boolean hasDoctor);
	
	public boolean addVehicle (int station, FireTruckKinds kind);
	
	public boolean removeVehicle (String ID);
}
