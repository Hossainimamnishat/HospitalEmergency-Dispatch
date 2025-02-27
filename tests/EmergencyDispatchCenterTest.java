package tests;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import classes.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmergencyDispatchCenterTest {
	
	@Test
	public void constructorTest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
	}
	
	@Test
	public void getFireStationsTest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		assert lst.getFireStations() != null;
	}
	
	@Test
	public void setFireStationsTest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		List<FireStation> stations = new List<>();
		lst.setFireStations(stations);
		assert lst.getFireStations() == stations;
	}
	
	@Test
	public void getEmergenciesTest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		assert lst.getEmergencies() != null;
	}
	
	@Test
	public void setEmergenciesTest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		List<Emergency> stations = new List<>();
		lst.setEmergencies(stations);
		assert lst.getEmergencies() == stations;
	}
	
	@Test
	public void addFireStationTest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		FireStation station = new FireStation (1, "Stein");
		lst.addFireStation(station);
		assert lst.getFireStations().get(0).getContent() == station;
	}
	
	@Test
	public void newCall () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		Emergency call = lst.newCall("Da", EmergencyKinds.FireSmall, 0, 0);
		assert call.getLocation().equals("Da");
		assert call.getCasualties() == 0;
		assert call.getCasualtiesNeedsDoctor() == 0;
		assert call.getKind() == EmergencyKinds.FireSmall;
	}
	
	@Test
	public void addCalltoList () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		Emergency call = new Emergency("Da", EmergencyKinds.MedicalEmergency, 1, 0);
		assert lst.addCalltoList(call) == true;
	}
	
	@Test
	public void dispatchVehiclesFalse () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		lst.addFireStation(new FireStation(1, "Da"));
		lst.getFireStations().get(0).getContent().addVehicle(FireTruckKinds.FireEngine);
		lst.addCalltoList(lst.newCall("Da", EmergencyKinds.TechnicalEmergencySmall, 0, 0));
		assert lst.dispatchVehicles() == false;
	}


	@Test
   	public void dispatchVehiclesTrue () {
        	EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
        	lst.addFireStation(new FireStation (1, "Da"));
        	lst.getFireStations().get(0).getContent().addVehicle(FireTruckKinds.FireEngine);
        	lst.addCalltoList(lst.newCall("Da", EmergencyKinds.FireSmall, 0, 0));
        	assert lst.dispatchVehicles() == true;
    	}

	@Test
	public void sortCalls () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		Emergency call = new Emergency("Da", EmergencyKinds.TechnicalEmergencySmall, 0, 0);
		Emergency call2 = new Emergency("Da", EmergencyKinds.HazmatEmergencyLarge, 0, 0);
		lst.addCalltoList(call);
		lst.addCalltoList(call2);
		lst.sortCalls();
		assert lst.getEmergencies().get(0).getContent() == call2;
		assert lst.getEmergencies().get(1).getContent() == call;
	}
	
	@Test
	public void sortVehicles () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		FireStation sta = new FireStation(1, "Da");
		FireTruck truck1 = new FireTruck(1, 2, FireTruckKinds.FireEngine);
		FireTruck truck2 = new FireTruck(1, 1, FireTruckKinds.FireEngine);
		sta.addVehicle(truck1);
		sta.addVehicle(truck2);
		lst.addFireStation(sta);
		lst.sortVehicles();
		assert lst.getFireStations().get(0).getContent().getFireTrucks().get(0).getContent() == truck2;
		assert lst.getFireStations().get(0).getContent().getFireTrucks().get(1).getContent() == truck1;
	}
	
	@Test
	public void printRespondingVehiclesTest () {
		PrintStream out = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		FireStation sta = new FireStation(1, "Da");
		FireTruck truck1 = new FireTruck(1, 2, FireTruckKinds.FireEngine);
		sta.addVehicle(truck1);
		lst.addFireStation(sta);
		Emergency call = new Emergency("Da", EmergencyKinds.FireSmall, 0, 0);
		lst.addCalltoList(call);
		lst.dispatchVehicles();
		lst.printRespondingVehicles(call);
		System.setOut(out);
		String expectedOutput  = "To FireSmall in Da is responding:\n1/49/2 - FireEngine";
		assertEquals(expectedOutput, baos.toString().trim());
	}

	@Test
	public void addVehicleAMObjTest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		FireStation one = new FireStation(1, "Da");
		one.addVehicle(false);
		lst.addFireStation(one);
		assert lst.addVehicle(1, false) == true;
	}
	
	@Test
	public void addVehicleFTObjTest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		FireStation one = new FireStation(1, "Da");
		lst.addFireStation(one);
		assert lst.addVehicle(1, FireTruckKinds.FireEngine) == true;
	}
	
	@Test
	public void removeVehicleOPTATest () {
		EmergencyDispatchCenter lst = new EmergencyDispatchCenter();
		FireStation one = new FireStation(1, "Da");
		lst.addFireStation(one);
		lst.addVehicle(1, FireTruckKinds.FireEngine);
		assert lst.removeVehicle("1/49/1") == true;
	}
}
