package com.jpm.calculator;

import java.util.List;

import com.jpm.model.Price;

/**
 * Calculates the GBCE All Share Index
 * 
 * @author MA
 *
 */
public class GbceIndexCalculator {

	/**
	 * Constructor
	 */
	public GbceIndexCalculator() {
	}

	/**
	 * Calculates the GBCE All Share Index
	 * 
	 * @param allPrices All prices of all stocks
	 * @return current value of the GBCE All Share Index
	 */
	public static double calculate(List<Price> allPrices) {

		double sum = 1;

		for (Price price : allPrices) {
			sum *= price.getPrice();
		}

		double size = allPrices.size();
		double x = 1 / size;

		return (double) Math.pow(sum, x);

	}
}
