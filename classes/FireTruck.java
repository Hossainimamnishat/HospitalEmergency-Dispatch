package classes;

import interfaces.I_FireTruck;

public class FireTruck implements I_FireTruck {

	private int stationNum;
	private int vehicleNum;
	private FireTruckKinds kind;
	private String id;
	private boolean isAvailable;
	public FireTruck(int stationNum,int vehicleNum,FireTruckKinds kind) {
		this.stationNum = stationNum;
		this.vehicleNum = vehicleNum;
		this.kind = kind;
		id=stationNum+"/"+49+"/"+vehicleNum;
		this.isAvailable=true;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public void setID(String ID) {
		id = ID;

	}

	@Override
	public FireTruckKinds getKind() {

		return kind;
	}

	@Override
	public void setKind(FireTruckKinds kind) {
		this.kind = kind;

	}

	@Override
	public String getType() {
		return "";
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setDispatched(boolean b) {
		isAvailable = !b;
	}
}
