package codeFromDeepinder;

import java.io.IOException;

import org.testng.annotations.Test;


public class ApplicationLogic {

	@Test
	public void applicationTest() throws IOException, InterruptedException {
		String[][] data = ReadExcel.getData("TestData.xlsx", "Sheet2");

		for (int i = 1; i < data.length; i++) {
			switch (data[i][3]) {

			case "openBrowser": // i=1,12
				Methods.openBrowser();
				break;

			case "maximizeBrowser": // i=2,13
				Methods.maximizeBrowser();
				break;

			case "implementImplicitWait":// i=3,14
				Methods.implementImplicitWait();
				break;

			case "navigateTo":// i=4,15
				Methods.goToUrl(data[i][6]);
				break;

			case "enterSource": // i=5,18
				Methods.enterSourceCity(data[i][5], data[i][6]);
				break;

			case "enterDestination": // i=6,19
				Methods.enterDestination(data[i][5], data[i][6]);
				break;

			case "selectDate":// i=7,20
				Methods.selectDateFromCalendar(data[i][1]);
				break;

			case "clickSearch":// i=8
				Methods.clickSearchButton(data[i][4], data[i][5]);
				break;

			case "pickPrice":// i=9
				Methods.pickLeastPrice(data[i][4], data[i][5]);
				break;

			case "pickAirline":// i=10
				Methods.pickAirlineName(data[i][4], data[i][5]);
				break;

			case "closeBrowser":// i=11
				Methods.closeBrowser();
				break;

			case "clickFlights":// i=16
				Methods.clickFlightTab(data[i][5]);
				break;

			case "selectOneWayTrip":// i=17
				Methods.selectOneWayTrip(data[i][5]);
				break;

			}
		}

	}

}
