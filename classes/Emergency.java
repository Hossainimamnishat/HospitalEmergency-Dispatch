package classes;

import interfaces.I_Emergency;

public class Emergency implements I_Emergency {
	private String location;
	private EmergencyKinds kind;
	private int patients;
	private int patientsDoc;
	public Emergency(String location, EmergencyKinds kind, int patients, int patientsDoc) {
		this.location = location;
		this.kind = kind;
		this.patients = patients;
		this.patientsDoc = patientsDoc;
	}

	@Override
	public String getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(String location) {
		this.location = location;

	}

	@Override
	public EmergencyKinds getKind() {

		return this.kind;
	}

	@Override
	public void setKind(EmergencyKinds kind) {
		this.kind = kind;

	}

	@Override
	public int getCasualties() {

		return this.patients;
	}

	@Override
	public void setCasualties(int casualties) {
		this.patients = casualties;

	}

	@Override
	public int getCasualtiesNeedsDoctor() {
		return this.patientsDoc;
	}

	@Override
	public void setCasualtiesNeedsDoctor(int casualtiesNeedsDoctor) {
		this.patientsDoc = casualtiesNeedsDoctor;

	}

	public void addRespondingVehicle(FireTruck truck) {
	}



}
