package tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import classes.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FireStationTest {

	@Test
	public void constructorTest () {
		FireStation station = new FireStation(1, "Baum");
	}
	
	@Test
	public void getNumberTest () {
		FireStation station = new FireStation(1, "Baum");
		assert station.getNumber() == 1;
	}
	
	@Test
	public void setNumberTest () {
		FireStation station = new FireStation(1, "Baum");
		station.setNumber(100);
		assert station.getNumber() == 100;
	}
	
	@Test
	public void getDistrictTest () {
		FireStation station = new FireStation(1, "Baum");
		assert station.getDistrict().equals("Baum");
	}
	
	@Test
	public void setDistrictTest () {
		FireStation station = new FireStation(1, "Baum");
		station.setDistrict("Stein");
		assert station.getDistrict().equals("Stein");
	}
	
	@Test
	public void getFireTrucksTest () {
		FireStation station = new FireStation(1, "Baum");
		assert station.getFireTrucks() != null;
	}
	
	@Test
	public void setFireTrucksTest () {
		FireStation station = new FireStation(1, "Baum");
		List<FireTruck> list = new List<>();
		station.setFireTrucks(list);
		assert station.getFireTrucks() == list;
	}
	
	@Test
	public void getAmbulancesTest () {
		FireStation station = new FireStation(1, "Baum");
		assert station.getAmbulances() != null;
	}
	
	@Test
	public void setAmbulancesTest () {
		FireStation station = new FireStation(1, "Baum");
		List<Ambulance> list = new List<>();
		station.setAmbulances(list);
		assert station.getAmbulances() == list;
	}
	
	@Test
	public void addVehicleFTObjTest () {
		FireStation station = new FireStation(1, "Baum");
		FireTruck truck = new FireTruck(1, 1, FireTruckKinds.FireEngine);
		assert station.addVehicle(truck) == true;
	}
	
	@Test
	public void addVehicleFTKindTest () {
		FireStation station = new FireStation(1, "Baum");
		assert station.addVehicle(FireTruckKinds.FireEngine) == true;
	}
	
	@Test
	public void addVehicleAMObjTest () {
		FireStation station = new FireStation(1, "Baum");
		Ambulance truck = new Ambulance(1, 1, false);
		assert station.addVehicle(truck) == true;
	}
	
	@Test
	public void addVehicleAMBoolTest () {
		FireStation station = new FireStation(1, "Baum");
		assert station.addVehicle(false) == true;
	}
	
	@Test
	public void removeVehicleFTObjTest () {
		FireStation station = new FireStation(1, "Baum");
		FireTruck truck = new FireTruck(1, 1, FireTruckKinds.FireEngine);
		station.addVehicle(truck);
		assert station.removeVehicle(truck) == true;
	}
	
	@Test
	public void removeVehicleAMObjTest () {
		FireStation station = new FireStation(1, "Baum");
		Ambulance truck = new Ambulance(1, 1, false);
		station.addVehicle(truck);
		assert station.removeVehicle(truck) == true;
	}
	
	@Test
	public void removeVehicleOPTATest () {
		FireStation station = new FireStation(1, "Baum");
		Ambulance truck = new Ambulance(1, 1, false);
		station.addVehicle(truck);
		assert station.removeVehicle("1/83/1") == true;
	}
	
	@Test
	public void printVehiclesTest () {
		PrintStream out = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
		FireStation station = new FireStation(1, "Baum");
		station.addVehicle(false);
		station.printVehicles();
		System.setOut(out);
		String expectedOutput  = "1/83/1 - Ambulance";
		assertEquals(expectedOutput, baos.toString().trim());
	
	}
	
	@Test
	public void sortVehicles () {
		FireStation station = new FireStation(1, "Baum");
		Ambulance truck = new Ambulance(1, 2, false);
		Ambulance truck2 = new Ambulance(1, 1, false);
		station.addVehicle(truck);
		station.addVehicle(truck2);
		station.printVehicles();
		station.sortVehicles();
		station.printVehicles();
		assert station.getAmbulances().get(0).getContent() == truck2;
		assert station.getAmbulances().get(1).getContent() == truck;
	}

}
