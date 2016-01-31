package com.jpm.calculator;

import com.jpm.model.PreferredStock;
import com.jpm.model.Stock;
import com.jpm.model.Stock.StockType;

/**
 * Calculates the dividend yield
 * <p>
 * Common Dividend = Last Dividend / Stockprice
 * </p>
 * <p>
 * Preferred Dividend = Fixed Dividend * Par Value / Stockprice
 * </p>
 * 
 * @author MA
 */
public class DividendYieldCalculator {

	/**
	 * Constructor
	 */
	public DividendYieldCalculator() {
	}

	/**
	 * Calculates the dividend yield
	 * 
	 * @param stock Stock
	 * @param stockPrice Stockprice
	 * @return Dividend Yield
	 */
	public static double calculate(Stock stock, double stockPrice) {

		if (StockType.COMMON.equals(stock.getType())) {

			final double lastDividend = ((double) stock.getLastDividend());
			return lastDividend / stockPrice;

		} else if (StockType.PREFERRED.equals(stock.getType())) {

			final PreferredStock preferredStock = (PreferredStock) stock;
			final double fixedDividend = ((double) preferredStock.getFixedDividend());
			final double parValue = ((double) preferredStock.getParValue());
			return fixedDividend * parValue / stockPrice;

		} else {
			throw new RuntimeException("Stocktype is empty");
		}
	}
}
