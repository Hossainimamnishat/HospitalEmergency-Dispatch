package classes;

import interfaces.I_FireStation;

public class FireStation implements I_FireStation {

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNumber(int number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDistrict() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDistrict(String district) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FireTruck> getFireTrucks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFireTrucks(List<FireTruck> fireTrucks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ambulance> getAmbulances() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAmbulances(List<Ambulance> ambulances) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addVehicle(FireTruck truck) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVehicle(FireTruckKinds truck) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVehicle(Ambulance ambulance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVehicle(boolean hasDoctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVehicle(FireTruck truck) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVehicle(Ambulance ambulance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVehicle(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printVehicles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortVehicles() {
		// TODO Auto-generated method stub
		
	}

}
