package com.calculationApp.service;

public class CalculatorAdditionService {
	
	public String addService(String inputA,String inputB) throws Exception{
		System.out.println("Entered addService:::inputA is "+inputA+"and InputB is "+inputB);
		String result=String.valueOf(Integer.parseInt(inputA)+Integer.parseInt(inputB));
		System.out.println("Exiting addService::"+result);
		
	return result;	
	}
	
	public String subtractService(String inputA,String inputB) throws Exception{
		System.out.println("Entered subtractService:::inputA is "+inputA+"and InputB is "+inputB);
		String result=String.valueOf(Integer.parseInt(inputA)-Integer.parseInt(inputB));
		System.out.println("Exiting subtractService::"+result);
		
	return result;	
	}

}
