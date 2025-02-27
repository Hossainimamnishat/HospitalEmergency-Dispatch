package classes;

import interfaces.I_Ambulance;

public class Ambulance implements I_Ambulance {
	public int stationNum;
	public int vehicleNum;
	private boolean hasDoctor;
	private String id;
	private int priority;

	public Ambulance(int stationNum, int vehicleNum, boolean hasDoctor) {
		this.stationNum = stationNum;
		this.vehicleNum = vehicleNum;
		this.hasDoctor = hasDoctor;
		if (this.hasDoctor) {
			this.id = String.format("%d/81/%d", stationNum, vehicleNum);
		}else {
			this.id = String.format("%d/83/%d", stationNum, vehicleNum);
		}
	}



	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public void setID(String ID) {
		this.id = ID;

	}

	@Override
	public boolean getHasDoctor() {
		return this.hasDoctor;
	}

	@Override
	public void setHasDoctor(boolean hasDoctor) {
		this.hasDoctor = hasDoctor;

	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
