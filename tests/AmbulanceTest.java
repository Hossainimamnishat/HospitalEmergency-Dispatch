package tests;

import org.junit.jupiter.api.Test;
import classes.*;

public class AmbulanceTest {

	@Test
	public void constructorTest () {
		Ambulance ambo = new Ambulance(1, 1, false);
	}
	
	@Test
	public void getOPTATest () {
		Ambulance ambo = new Ambulance(1, 1, false);
		assert ambo.getID().equals("1/83/1");
	}
	
	@Test
	public void setIDTest () {
		Ambulance ambo = new Ambulance(1, 1, false);
		ambo.setID("2/84/2");
		assert ambo.getID().equals("2/84/2");
	}
	
	@Test
	public void getHasDoctorTest () {
		Ambulance ambo = new Ambulance(1, 1, false);
		assert ambo.getHasDoctor() == false;
	}
	
	@Test
	public void setHasDoctorTest () {
		Ambulance ambo = new Ambulance(1, 1, false);
		ambo.setHasDoctor(true);
		assert ambo.getHasDoctor() == true;
	}
}
