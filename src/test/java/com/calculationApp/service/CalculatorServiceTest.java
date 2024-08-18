package com.calculationApp.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculatorServiceTest {

	@Test
	public void testAddService() throws Exception{
		CalculatorAdditionService additionService = new CalculatorAdditionService();
		assertTrue("Invalid add service response:",additionService.addService("2", "3").equals("5"));
	}
	
	@Test
	public void testSubstractService() throws Exception{
		CalculatorAdditionService additionService = new CalculatorAdditionService();
		assertTrue("Invalid substract service response:",additionService.subtractService("3", "2").equals("1"));
	}

}
