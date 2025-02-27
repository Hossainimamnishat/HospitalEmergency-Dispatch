package interfaces;

import classes.*;

public interface I_FireTruck {
	public String getID();
	public void setID(String ID);
	public FireTruckKinds getKind();
	public void setKind(FireTruckKinds kind);
}
