package com.jpm.calculator;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import com.jpm.model.Trade;

/**
 * Calculates the Stockprice
 * 
 * @author MA
 *
 */
public class StockPriceCalculator {

	/**
	 * Constructor
	 */
	public StockPriceCalculator() {
	}

	/**
	 * Calculates the Stockprice
	 * 
	 * @param relevantTrades Only Trade of a single stock
	 * @return Stockprice
	 */
	public static double calculate(List<Trade> relevantTrades) {

		int tradesSum = 0;
		int quantitiesSum = 0;
		double stockPrice = 0;

		// Get timestamp 15 min. ago
		final Date now = new Date();
		long ago15Min = now.getTime() - (15 * 60 * 1000);
		final Date timeLimit = new Date();
		timeLimit.setTime(ago15Min);

		final ListIterator<Trade> it = relevantTrades.listIterator(relevantTrades.size());
		boolean isWithin15min = true;

		// Calculate all trades which have been received for the last 15 min.
		while (it.hasPrevious() && isWithin15min) {

			Trade trade = it.previous();

			if (trade.getTimestamp().after(timeLimit)) {

				tradesSum += trade.getPrice() * trade.getQuantity();
				quantitiesSum += trade.getQuantity();

			} else {
				isWithin15min = false;
			}

		}
		stockPrice = ((double) tradesSum) / ((double) quantitiesSum);

		return stockPrice;

	}

}
