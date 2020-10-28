

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany myMgmtCo;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		myMgmtCo = new ManagementCompany("MyMgmtCo","12345",5.0);
		//student add three properties, with plots, to mgmt co
		myMgmtCo.addProperty("YourFirst", "Rockville", 1000.0, "You", 1, 2, 3, 3);
		myMgmtCo.addProperty("YourSecond", "Rockville", 1500.0, "You", 4, 2, 3, 3);
		myMgmtCo.addProperty("YourThird", "Rockville", 2000.0, "You", 7, 2, 3, 3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		myMgmtCo = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		// fail("STUDENT test not implemented yet");
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(myMgmtCo.addProperty("YourFourth", "Rockville", 1250.0, "You"), 3);
		//student should add property with 8 args
		assertEquals(myMgmtCo.addProperty("YourFifth", "Rockville", 1750.0, "You", 1, 5, 3, 3), 4);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(myMgmtCo.addProperty("YourSixth", "Rockville", 2250.0, "You", 4, 5, 3, 3), -1);
	}
 
	@Test
	public void testMaxRentProp() {
		// fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		assertTrue(myMgmtCo.maxRentProp().contains("YourThird"));
		
	}

	@Test
	public void testTotalRent() {
		// fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(myMgmtCo.totalRent(), 4500.0, 0);
	}

 }