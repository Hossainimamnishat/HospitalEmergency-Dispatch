package classes;

import interfaces.I_EmergencyDispatchCenter;

public class EmergencyDispatchCenter implements I_EmergencyDispatchCenter {

	private List<FireStation> fireStations;
	private List<Emergency> emergencies;

	public EmergencyDispatchCenter() {
		fireStations = new List<>();
		emergencies = new List<>();
	}

	@Override
	public List<FireStation> getFireStations() {

		return this.fireStations;
	}

	@Override
	public void setFireStations(List<FireStation> fireStations) {
		this.fireStations = fireStations;

	}

	@Override
	public List<Emergency> getEmergencies() {

		return this.emergencies;
	}

	@Override
	public void setEmergencies(List<Emergency> emergencies) {
		this.emergencies = emergencies;

	}

	@Override
	public boolean addFireStation(FireStation station) {
		if (station == null) return false;
		return fireStations.append(new Node<>(station));
	}

	@Override
	public Emergency newCall(String location, EmergencyKinds kind, int patients, int patientsDoc) {
		return new Emergency(location, kind, patients, patientsDoc);
	}

	@Override
	public boolean addCalltoList(Emergency call) {
		if (call == null) return false;
		return emergencies.append(new Node<>(call));
	}



	@Override
	public boolean dispatchVehicles() {
		boolean allDispatched = true;
		sortCalls();

		for (int i = 0; i < emergencies.getSize(); i++) {
			Emergency emergency = emergencies.get(i).getContent();
			boolean dispatched = false;

			if (emergency.getKind().equals(EmergencyKinds.FireSmall)) {
				dispatched = dispatchFireTrucks(emergency, 1);
			} else if (emergency.getKind().equals(EmergencyKinds.TechnicalEmergencySmall)) {
				dispatched = dispatchFireTrucks(emergency, 1, FireTruckKinds.LadderTruck);
			} else if (emergency.getKind().equals(EmergencyKinds.HazmatEmergencySmall)) {
				dispatched = dispatchFireTrucks(emergency, 2);
			} else if (emergency.getKind().equals(EmergencyKinds.FireMiddle)) {
				dispatched = dispatchFireTrucks(emergency, 3, FireTruckKinds.LadderTruck, FireTruckKinds.CommandVehicle);
			} else if (emergency.getKind().equals(EmergencyKinds.TechnicalEmergencyMiddle)) {
				dispatched = dispatchFireTrucks(emergency, 2, FireTruckKinds.RescueTruck, FireTruckKinds.CommandVehicle);
			} else if (emergency.getKind().equals(EmergencyKinds.HazmatEmergencyMiddle)) {
				dispatched = dispatchFireTrucks(emergency, 2, FireTruckKinds.HazmatTruck, FireTruckKinds.RescueTruck, FireTruckKinds.CommandVehicle);
			} else if (emergency.getKind().equals(EmergencyKinds.FireLarge)) {
				dispatched = dispatchFireTrucks(emergency, 5, FireTruckKinds.RescueTruck, FireTruckKinds.LadderTruck, FireTruckKinds.LadderTruck, FireTruckKinds.CommandVehicle);
			} else if (emergency.getKind().equals(EmergencyKinds.TechnicalEmergencyLarge)) {
				dispatched = dispatchFireTrucks(emergency, 4, FireTruckKinds.RescueTruck, FireTruckKinds.RescueTruck, FireTruckKinds.LadderTruck, FireTruckKinds.CommandVehicle);
			} else if (emergency.getKind().equals(EmergencyKinds.HazmatEmergencyLarge)) {
				dispatched = dispatchFireTrucks(emergency, 4, FireTruckKinds.HazmatTruck, FireTruckKinds.HazmatTruck, FireTruckKinds.RescueTruck, FireTruckKinds.LadderTruck, FireTruckKinds.CommandVehicle);
			}

			if (!dispatched) {
				allDispatched = false;
			}
		}
		return allDispatched;
	}


	/**
	 * Dispatches the required number of available FireEngines for the given emergency.

	 * @param emergency The emergency requiring fire truck dispatch.
	 * @param engineCount Number of FireEngines needed.
	 * @param additionalVehicles Additional fire truck types to be dispatched (handled elsewhere).
	 * @return true if dispatching proceeds (completion check handled later).
	 */
	private boolean dispatchFireTrucks(Emergency emergency, int engineCount, FireTruckKinds... additionalVehicles) {
		int dispatchedEngines = 0;
		List<FireTruck> dispatchedVehicles = new List<>();

		// Dispatch Fire Engines first
		for (int i = 0; i < fireStations.getSize(); i++) {
			FireStation station = fireStations.get(i).getContent();
			List<FireTruck> fireTrucks = station.getFireTrucks();

			for (int j = 0; j < fireTrucks.getSize(); j++) {
				FireTruck truck = fireTrucks.get(j).getContent();
				if (truck.isAvailable() && truck.getKind().equals(FireTruckKinds.FireEngine)) {
					truck.setDispatched(true);
					dispatchedVehicles.append(new Node<>(truck));
					dispatchedEngines++;
					if (dispatchedEngines == engineCount) break;
				}
			}
			if (dispatchedEngines == engineCount) break;
		}



		// Dispatch additional vehicle types
		for (FireTruckKinds kind : additionalVehicles) {
			boolean vehicleDispatched = false;

			for (int i = 0; i < fireStations.getSize(); i++) {
				FireStation station = fireStations.get(i).getContent();
				List<FireTruck> fireTrucks = station.getFireTrucks();

				for (int j = 0; j < fireTrucks.getSize(); j++) {
					FireTruck truck = fireTrucks.get(j).getContent();
					if (truck.getKind().equals(kind) && truck.isAvailable()) {
						truck.setDispatched(true);
						dispatchedVehicles.append(new Node<>(truck));
						vehicleDispatched = true;
						break;
					}

				}
				if (vehicleDispatched) break;
			}
		}







		if (dispatchedVehicles.getSize() >= engineCount + additionalVehicles.length) {
			for (int i = 0; i < dispatchedVehicles.getSize(); i++) {
				FireTruck truck = dispatchedVehicles.get(i).getContent();
				// System.out.println(truck.getID() + " - " + truck.getKind());
			}
			return true;
		}
		return false;
	}
	@Override
	public void sortCalls() {
		bubbleSort(emergencies);

	}

	@Override
	public void sortVehicles() {
		for (int i = 0; i < fireStations.getSize(); i++) {
			fireStations.get(i).getContent().sortVehicles();
		}

	}


	@Override
	public void printRespondingVehicles(Emergency call) {
		List<String> respondingVehicles = new List<>();

		// Collect Fire Trucks that are NOT available (indicating they are dispatched)
		for (int i = 0; i < fireStations.getSize(); i++) {
			FireStation station = fireStations.get(i).getContent();
			List<FireTruck> fireTrucks = station.getFireTrucks();

			for (int j = 0; j < fireTrucks.getSize(); j++) {
				FireTruck truck = fireTrucks.get(j).getContent();
				if (!truck.isAvailable()) {  // Fire truck is dispatched if it's NOT available
					respondingVehicles.append(new Node<>(truck.getID() + " - " + truck.getKind()));
				}
			}
		}

		// Collect Ambulances based on the number of casualties (without checking availability)
		int ambulanceCount = call.getCasualties();
		int doctorRequired = call.getCasualtiesNeedsDoctor();

		for (int i = 0; i < fireStations.getSize(); i++) {
			FireStation station = fireStations.get(i).getContent();
			List<Ambulance> ambulances = station.getAmbulances();

			for (int j = 0; j < ambulances.getSize(); j++) {
				if (ambulanceCount == 0) break;  // Stop when all required ambulances are assigned

				Ambulance ambulance = ambulances.get(j).getContent();
				String format;

				if (doctorRequired > 0 && ambulance.getHasDoctor()) {
					format = ambulance.getID() + " - Ambulance(Doctor)";
					doctorRequired--; // Reduce required doctors count
				} else {
					format = ambulance.getID() + " - Ambulance";
				}

				respondingVehicles.append(new Node<>(format));
				ambulanceCount--; // Reduce the required ambulance count
			}
		}

		// Sort vehicles by ID (ensuring output is in ascending order)
		bubbleSort(respondingVehicles);

		// Print formatted output (using System.out.print() as required)
		System.out.print("To " + call.getKind() + " in " + call.getLocation() + " is responding:\n");
		for (int i = 0; i < respondingVehicles.getSize(); i++) {
			System.out.print(respondingVehicles.get(i).getContent() + "\n");  // Print each vehicle on a new line
		}
	}

	@Override
	public boolean addVehicle(int station, boolean hasDoctor) {
		for (int i = 0; i < fireStations.getSize(); i++) {
			if(fireStations.get(i).getContent().getNumber()==station){
				fireStations.get(i).getContent().addVehicle(hasDoctor);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addVehicle(int station, FireTruckKinds kind) {
		for (int i = 0; i < fireStations.getSize(); i++) {
			if(fireStations.get(i).getContent().getNumber()==station){
				fireStations.get(i).getContent().addVehicle(kind);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeVehicle(String ID) {
		for (int i = 0; i < fireStations.getSize(); i++) {
			List<Ambulance> ambulanceList=fireStations.get(i).getContent().getAmbulances();
			List<FireTruck> fireTruckList=fireStations.get(i).getContent().getFireTrucks();
			for (int j = 0; j < ambulanceList.getSize(); j++) {
				if(ambulanceList.get(j).getContent().getID().equals(ID)){
					ambulanceList.remove(j);
					return true;
				}
			}
			for (int j = 0; j < fireTruckList.getSize(); j++) {
				if(fireTruckList.get(j).getContent().getID().equals(ID)){
					fireTruckList.remove(j);
					return true;
				}
			}

		}
		return false;
	}
	/* i got this solution from ChatGpt
	 * Bubble-sort
	 */

	private <T> List<T> bubbleSort(List<T> list) {
		for (int i = 0; i < list.getSize() - 1; i++) {
			for (int j = 0; j < list.getSize() - i - 1; j++) {
				Emergency current = (Emergency) list.get(j).getContent();
				Emergency next = (Emergency) list.get(j + 1).getContent();
				if(needSwap(next.getKind(),current.getKind())){
					list.swap(j,j+1);
				}
			}
		}
		return list;
	}

	private boolean needSwap(EmergencyKinds a,EmergencyKinds b){
		if(isLarge(a)){
			if(isMiddle(b) || isSmall(b) || b==EmergencyKinds.MedicalEmergency){
				return true;
			}else{
				return false;
			}
		}else if(isMiddle(a)){
			if(isSmall(b) || b==EmergencyKinds.MedicalEmergency){
				return true;
			}else {
				return false;
			}
		}else if(isSmall(b) && b==EmergencyKinds.MedicalEmergency){
			return true;
		}else {
			return false;
		}

	}

	private boolean isLarge(EmergencyKinds kind) {
		if(kind==EmergencyKinds.FireLarge || kind ==EmergencyKinds.TechnicalEmergencyLarge || kind ==EmergencyKinds.HazmatEmergencyLarge){
			return true;
		}else {
			return false;
		}

	}
	private boolean isMiddle(EmergencyKinds kind) {
		if(kind==EmergencyKinds.FireMiddle || kind ==EmergencyKinds.TechnicalEmergencyMiddle || kind ==EmergencyKinds.HazmatEmergencyMiddle){
			return true;
		}else {
			return false;
		}

	}
	private boolean isSmall(EmergencyKinds kind) {
		if(kind==EmergencyKinds.FireSmall || kind ==EmergencyKinds.TechnicalEmergencySmall || kind ==EmergencyKinds.HazmatEmergencySmall){
			return true;
		}else {
			return false;
		}

	}



	private boolean dispatchForSmallFire2(Emergency emergency) {
		boolean dispatched =false;
		List<FireTruck> dispatchedFireTurks=new List<>();
		for (int j = 0; j < fireStations.getSize(); j++) {
			List<FireTruck> fireTruckList= 	fireStations.get(j).getContent().getFireTrucks();
			if(fireTruckList.getSize()>0) {
				for (int k = 0; k < fireTruckList.getSize(); k++) {
					if(fireTruckList.get(k).getContent().isAvailable()){
						fireTruckList.get(k).getContent().setDispatched(true);
						dispatchedFireTurks.append(fireTruckList.get(k));
						dispatched=true;
						System.out.println("To "+emergency.getKind()+" in "+fireStations.get(j).getContent().getDistrict()+" is responding:\n"+fireTruckList.get(k).getContent().getID()+" - "+fireTruckList.get(k).getContent().getKind());
						break;
					}
				}
				if(dispatched){
					break;
				}
			}
		}
		return dispatched;
	}


	private boolean dispatchForTechnicalEmergencySmall2(Emergency emergency) {
		List<FireTruck> fireTruckDispatched=new List<>();
		boolean dispatched = false;
		for (int j = 0; j < fireStations.getSize(); j++) {
			List<FireTruck> fireTruckList= 	fireStations.get(j).getContent().getFireTrucks();
			if(fireTruckList.getSize()>0) {
				for (int k = 0; k < fireTruckList.getSize(); k++) {
					if(fireTruckList.get(k).getContent().isAvailable()){
						fireTruckList.get(k).getContent().setDispatched(true);
						fireTruckDispatched.append(fireTruckList.get(k));
						System.out.println("To "+emergency.getKind()+" in "+fireStations.get(j).getContent().getDistrict()+" is responding:\n"+fireTruckList.get(k).getContent().getID()+" - "+fireTruckList.get(k).getContent().getKind());
						break;
					}
				}
				if(dispatched){
					break;
				}
			}
		}
		return dispatched;
	}

	//dispatchForMedicalEmergency
	//For MedicalEmergency,No fireTruck is dispatched, only ambulances are dispatched with doctors how many patients need doctor according to the emergency
	private boolean dispatchForMedicalEmergency(Emergency emergency) {
		List<Ambulance> dispatchedAmbulances=new List<>();
		boolean dispatched = false;
		int doctorCount=emergency.getCasualtiesNeedsDoctor();
		int ambulanceCount=emergency.getCasualties();
		for (int j = 0; j < fireStations.getSize(); j++) {
			List<Ambulance> ambulanceList= 	fireStations.get(j).getContent().getAmbulances();
			if(ambulanceList.getSize()>0) {
				for (int k = 0; k < ambulanceList.getSize(); k++) {
					if(ambulanceCount>0){
						if(doctorCount>0){
							if(ambulanceList.get(k).getContent().getHasDoctor()){
								doctorCount--;
								ambulanceCount--;
								dispatchedAmbulances.append(ambulanceList.get(k));
								dispatched=true;
								System.out.println("To "+emergency.getKind()+" in "+fireStations.get(j).getContent().getDistrict()+" is responding:\n"+ambulanceList.get(k).getContent().getID()+" - "+ambulanceList.get(k).getContent().getHasDoctor());
								if(doctorCount==0){
									break;
								}
							}
						}else{
							ambulanceCount--;
							dispatchedAmbulances.append(ambulanceList.get(k));
							dispatched=true;
							System.out.println("To "+emergency.getKind()+" in "+fireStations.get(j).getContent().getDistrict()+" is responding:\n"+ambulanceList.get(k).getContent().getID()+" - "+ambulanceList.get(k).getContent().getHasDoctor());
						}
					}else {
						break;
					}

				}
				if(ambulanceCount==0){
					break;
				}
			}
		}
		return dispatched;
	}



}
