package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.responses.BadRequestResponseStatus;
import com.example.utils.OperationsUtils;

@RestController
public class MathController {
		
	@RequestMapping(value = "/Sum/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") double numberOne,
		@PathVariable(value = "numberTwo") double numberTwo) throws Exception
	{
		return OperationsUtils.Sum(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/Subtract/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double Subtract(
			@PathVariable(value = "numberOne") double numberOne,
		@PathVariable(value = "numberTwo") double numberTwo) throws Exception
	{

		return OperationsUtils.Subtract(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/Multiplication/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double Multiplication(
			@PathVariable(value = "numberOne") double numberOne,
		@PathVariable(value = "numberTwo") double numberTwo) throws Exception
	{
		return OperationsUtils.Multiplication(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/Division/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double Division(
			@PathVariable(value = "numberOne") double numberOne,
		@PathVariable(value = "numberTwo") double numberTwo) throws Exception
	{
		return OperationsUtils.Multiplication(numberOne, numberTwo);
	}

}

