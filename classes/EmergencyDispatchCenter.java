package classes;

import interfaces.I_EmergencyDispatchCenter;

public class EmergencyDispatchCenter implements I_EmergencyDispatchCenter {

	@Override
	public List<FireStation> getFireStations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFireStations(List<FireStation> fireStations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Emergency> getEmergencies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmergencies(List<Emergency> emergencies) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addFireStation(FireStation station) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emergency newCall(String location, EmergencyKinds kind, int patients, int patientsDoc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCalltoList(Emergency call) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchVehicles() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sortCalls() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortVehicles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printRespondingVehicles(Emergency call) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addVehicle(int station, boolean hasDoctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVehicle(int station, FireTruckKinds kind) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVehicle(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

}
