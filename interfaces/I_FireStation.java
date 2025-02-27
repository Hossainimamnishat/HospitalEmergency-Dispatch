package interfaces;

import classes.*;

public interface I_FireStation {
	
	public int getNumber ();
	
	public void setNumber (int number);
	
	public String getDistrict ();
	
	public void setDistrict (String district);
	
	public List<FireTruck> getFireTrucks();
	
	public void setFireTrucks(List<FireTruck> fireTrucks);
	
	public List<Ambulance> getAmbulances();
	
	public void setAmbulances(List<Ambulance> ambulances);
	
	public boolean addVehicle (FireTruck truck);
	
	public boolean addVehicle (FireTruckKinds truck);
	
	public boolean addVehicle (Ambulance ambulance);
	
	public boolean addVehicle (boolean hasDoctor);
	
	public boolean removeVehicle (FireTruck truck);
	
	public boolean removeVehicle (Ambulance ambulance);
	
	public boolean removeVehicle (String ID);
	
	public void printVehicles ();
	
	public void sortVehicles ();
}
