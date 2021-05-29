package in.nandhini.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import in.nandhini.model.MessageConstants;

public class TestBillManager {

	/**
	 * test case to calculate the total bill amount
	 */
	@Test
	public void test1() {
		String startDate = "2021-06-06 01:10";// Given startDate
		String endDate = "2021-06-09 06:30";// Given endDate
		String roomChoice = MessageConstants.MOUNTAINVIEW;
		String acChoice = MessageConstants.WITHAC;
		String poolChoice = MessageConstants.WITHPOOL;
		String pickUpDropChoice = MessageConstants.NOTRANSPORT;
		ArrayList<String> list = new ArrayList<>
		(Arrays.asList(startDate, endDate, roomChoice, acChoice,poolChoice,pickUpDropChoice));
	    LinkedHashMap<String, Double> priceList = BillManager.totalBill(list);
	    double totalAmount = 0;
	    for(String price :priceList.keySet()) {
	    	totalAmount=priceList.get(price);
	    	if (price=="Total with GST") {
	    		break;
	    	}
	    }
		assertEquals(29425.0,totalAmount,0.01);
	}

	@Test
	public void test2() {
		String startDate = "2021-06-06 01:10";// Given startDate
		String endDate = "2021-06-08 07:30";// Given endDate
		String roomChoice = MessageConstants.OCEANVIEW;
		String acChoice = MessageConstants.WITHOUTAC;
		String poolChoice =  MessageConstants.WITHPOOL;;
		String pickUpDropChoice =  MessageConstants.TRANSPORT;
		List<String> list = new ArrayList<>
		(Arrays.asList(startDate, endDate, roomChoice, acChoice,poolChoice,pickUpDropChoice));
	    LinkedHashMap<String,Double> priceList = BillManager.totalBill(list);
	    double totalAmount =0;
	    for(String price :priceList.keySet()) {
	    	totalAmount=priceList.get(price);
	    	if (price=="Total with GST") {
	    		break;
	    	}
	    }
		assertEquals(25145.0, totalAmount,0.1);
	}
}
