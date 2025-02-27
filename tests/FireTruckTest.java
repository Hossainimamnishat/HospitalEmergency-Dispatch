package tests;

import org.junit.jupiter.api.Test;
import classes.*;

public class FireTruckTest {
	
	@Test
	public void constructorTest () {
		FireTruck truck = new FireTruck (1,1,FireTruckKinds.FireEngine);
	}
	
	@Test	
	public void getIDTest () {
		FireTruck truck = new FireTruck (1,1,FireTruckKinds.FireEngine);
		assert truck.getID().equals("1/49/1");
	}
	
	@Test
	public void setIDTest () {
		FireTruck truck = new FireTruck (1,1,FireTruckKinds.FireEngine);
		truck.setID("2/100/2");
		assert truck.getID().equals("2/100/2");
	}
	
	@Test
	public void getKindTest () {
		FireTruck truck = new FireTruck (1,1,FireTruckKinds.FireEngine);
		assert truck.getKind() == FireTruckKinds.FireEngine;
	}
	
	@Test
	public void setKindTest () {
		FireTruck truck = new FireTruck (1,1,FireTruckKinds.FireEngine);
		truck.setKind(FireTruckKinds.CommandVehicle);
		assert truck.getKind() == FireTruckKinds.CommandVehicle;
	}

}
