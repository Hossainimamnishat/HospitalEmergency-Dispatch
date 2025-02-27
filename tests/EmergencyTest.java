package tests;

import org.junit.jupiter.api.Test;
import classes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmergencyTest {

	@Test
	public void constructorTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
	}
	
	@Test
	public void getLocationTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
		assert call.getLocation().equals("Baum");
	}
	
	@Test
	public void setLocationTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
		call.setLocation("Stein");
		assert call.getLocation().equals("Stein");
	}
	
	@Test
	public void getKindTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
		assert call.getKind() == EmergencyKinds.FireMiddle;
	}
	
	@Test
	public void setKindTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
		call.setKind(EmergencyKinds.HazmatEmergencySmall);
		assert call.getKind() == EmergencyKinds.HazmatEmergencySmall;
	}
	
	@Test
	public void getCasultiesTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
		assert call.getCasualties() == 0;
	}
	
	@Test
	public void setCasultiesTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
		call.setCasualties(100);
		assert call.getCasualties() == 100;
	}
	
	@Test
	public void getCasultiesNeedsDoctorTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
		assert call.getCasualtiesNeedsDoctor() == 0;
	}
	
	@Test
	public void setCasultiesNeedsDoctorTest () {
		Emergency call = new Emergency("Baum", EmergencyKinds.FireMiddle, 0, 0);
		call.setCasualtiesNeedsDoctor(100);
		assert call.getCasualtiesNeedsDoctor() == 100;
	}
}
