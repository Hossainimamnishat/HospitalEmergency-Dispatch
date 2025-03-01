package classes;

import interfaces.I_FireStation;

public class FireStation implements I_FireStation {

	private int number;
	private String district;
	private List<FireTruck> fireTrucks;
	private List<Ambulance> ambulances;

	public FireStation(int number, String district) {
		this.number = number;
		this.district = district;
		this.fireTrucks = new List<>();
		this.ambulances = new List<>();
	}


	@Override
	public int getNumber() {
		return this.number;
	}

	@Override
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String getDistrict() {
		return this.district;
	}

	@Override
	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public classes.List<FireTruck> getFireTrucks() {
		return (classes.List<FireTruck>) this.fireTrucks;
	}

	@Override
	public void setFireTrucks(List<FireTruck> fireTrucks) {
		this.fireTrucks = fireTrucks;
	}

	@Override
	public void setFireTrucks(java.util.List<FireTruck> fireTrucks) {
		this.fireTrucks = convertToCustomList(fireTrucks);
	}

	@Override
	public List<Ambulance> getAmbulances() {
		return ambulances;
	}

	@Override
	public void setAmbulances(List<Ambulance> ambulances) {
		this.ambulances = ambulances;
	}

	@Override
	public void setAmbulances(java.util.List<Ambulance> ambulances) {
		this.ambulances = convertToCustomList(ambulances);
	}

	@Override
	public boolean addVehicle(FireTruck truck) {
		if (fireTrucks.append(new Node<>(truck))) {
			sortVehicles();
			return true;
		}
		return false;
	}

	@Override
	public boolean addVehicle(FireTruckKinds truck) {
		int vehicleNum = fireTrucks.getSize() + 1;
		FireTruck fireTruck = new FireTruck(number, vehicleNum, truck);
		return addVehicle(fireTruck);
	}

	@Override
	public boolean addVehicle(Ambulance ambulance) {
		if (ambulances.append(new Node<>(ambulance))) {
			sortVehicles();
			return true;
		}
		return false;
	}

	@Override
	public boolean addVehicle(boolean hasDoctor) {
		int vehicleNum = ambulances.getSize() + 1;
		Ambulance ambulance = new Ambulance(number, vehicleNum, hasDoctor);
		return addVehicle(ambulance);
	}

	@Override
	public boolean removeVehicle(FireTruck truck) {
		if (fireTrucks.remove(truck)) {
			reassignIDs(fireTrucks);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeVehicle(Ambulance ambulance) {
		if (ambulances.remove(ambulance)) {
			reassignIDs(ambulances);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeVehicle(String ID) {
		for (int i = 0; i < fireTrucks.getSize(); i++) {
			FireTruck truck = fireTrucks.get(i).getContent();
			if (truck.getID().equals(ID)) {
				return removeVehicle(truck);
			}
		}
		for (int i = 0; i < ambulances.getSize(); i++) {
			Ambulance ambulance = ambulances.get(i).getContent();
			if (ambulance.getID().equals(ID)) {
				return removeVehicle(ambulance);
			}
		}
		return false;
	}

	@Override
	public void printVehicles() {
		//System.out.print("station " + number + ":\n");
		for (int i = 0; i < fireTrucks.getSize(); i++) {
			FireTruck truck = fireTrucks.get(i).getContent();
			System.out.print(truck.getID() + " - " + truck.getKind() + "\n");
		}
		for (int i = 0; i < ambulances.getSize(); i++) {
			Ambulance ambulance = ambulances.get(i).getContent();
			System.out.print(ambulance.getID() + " - Ambulance" + (ambulance.getHasDoctor() ? "(Doctor)" : "") + "\n");
		}
	}


	@Override
	public void sortVehicles() {
		bubbleSort(fireTrucks);
		bubbleSort(ambulances);
	}
	private <T> void bubbleSort(List<T> vehicles) {
		for (int i = 0; i < vehicles.getSize() - 1; i++) {
			for (int j = 0; j < vehicles.getSize() - i - 1; j++) {
				T current = vehicles.get(j).getContent();
				T next = vehicles.get(j + 1).getContent();

				String currentID = getVehicleID(current);
				String nextID = getVehicleID(next);

				if (currentID != null && nextID != null && currentID.compareTo(nextID) > 0) {
					vehicles.swap(j, j + 1);
				}
			}
		}
	}

	private <T> String getVehicleID(T vehicle) {
		if (vehicle instanceof FireTruck) {
			return ((FireTruck) vehicle).getID();
		} else if (vehicle instanceof Ambulance) {
			return ((Ambulance) vehicle).getID();
		}
		return null; // Unsupported type
	}


	private <T> List<T> convertToCustomList(java.util.List<T> javaList) {
		List<T> customList = new List<>();
		for (T item : javaList) {
			customList.append(new Node<>(item));
		}
		return customList;
	}

	private <T> void reassignIDs(List<T> vehicles) {
		for (int i = 0; i < vehicles.getSize(); i++) {
			T vehicle = vehicles.get(i).getContent();
			if (vehicle instanceof FireTruck) {
				FireTruck fireTruck = (FireTruck) vehicle;
				fireTruck.setID(number + "/49/" + (i + 1)); // Example for FireTruck typeCode
			} else if (vehicle instanceof Ambulance) {
				Ambulance ambulance = (Ambulance) vehicle;
				ambulance.setID(number + "/83/" + (i + 1)); // Example for Ambulance typeCode
			}
		}
	}

}
