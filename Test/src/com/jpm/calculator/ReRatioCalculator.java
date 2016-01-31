package com.jpm.calculator;

import com.jpm.model.PreferredStock;
import com.jpm.model.Stock;

/**
 * Calculates the P/E Ratio
 * 
 * <p>
 * P/E Ratio = Last Dividend + Fixed Dividend (if available) / Stockprice
 * </p>
 * 
 * @author MA
 *
 */
public class ReRatioCalculator {

	/**
	 * Calculator
	 */
	public ReRatioCalculator() {
	}

	/**
	 * Calculates the P/E Ratio
	 * 
	 * @param stock Stock
	 * @param stockPrice Stockprice
	 * @return P/E Ratio
	 */
	public static double calculate(Stock stock, double stockPrice) {

		int lastDividend = stock.getLastDividend();
		int fixedDividend = 0;

		if (stock instanceof PreferredStock) {
			fixedDividend = ((PreferredStock) stock).getFixedDividend();
		}

		int dividend = lastDividend + fixedDividend;

		return dividend == 0 ? 0 : stockPrice / ((double) dividend);

	}

}
