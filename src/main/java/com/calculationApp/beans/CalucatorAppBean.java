package com.calculationApp.beans;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.calculationApp.service.CalculatorAdditionService;

@ManagedBean
@SessionScoped
public class CalucatorAppBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String inputA;
	
	private String inputB;
	
   private String calculationResult;
	
	private String errorMessage;
	
	
	public String getInputA() {
		return inputA;
	}

	public void setInputA(String inputA) {
		this.inputA = inputA;
	}

	public String getInputB() {
		return inputB;
	}

	public void setInputB(String inputB) {
		this.inputB = inputB;
	}

	public String getCalculationResult() {
		return calculationResult;
	}

	public void setCalculationResult(String calculationResult) {
		this.calculationResult = calculationResult;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	public String calculate() throws Exception{
		System.out.println("Entered calculate");
		CalculatorAdditionService calculatorAdditionService = new CalculatorAdditionService();
		try {
			calculationResult =calculatorAdditionService.addService(inputA, inputB);
		}
		catch(Exception e) {
			System.err.println("Exception occurred in calculate method"+e.getMessage());
			errorMessage="Error occurred while processing calculation with inputA:"+inputA+ " and InputB"+inputB;
			e.printStackTrace();
			return "errorPage";
		}
		System.out.println("Exiting calculate");
		return "successPage";
	}

	@Override
	public String toString() {
		return "CalucatorAppBean [inputA=" + inputA + ", inputB=" + inputB + ", calculationResult=" + calculationResult
				+ ", errorMessage=" + errorMessage + "]";
	}
	
	
}
