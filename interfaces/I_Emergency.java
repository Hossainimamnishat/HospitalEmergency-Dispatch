package interfaces;

import classes.EmergencyKinds;

public interface I_Emergency {
	public String getLocation();
	public void setLocation(String location);
	public EmergencyKinds getKind();
	public void setKind(EmergencyKinds kind);
	public int getCasualties();
	public void setCasualties(int casualties);
	public int getCasualtiesNeedsDoctor();
	public void setCasualtiesNeedsDoctor(int casualtiesNeedsDoctor);
}
