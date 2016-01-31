/**
 * 
 */
package com.jpm.model;

/**
 * Represents a single Preferred Stock
 * 
 * @author MA
 */
public class PreferredStock extends Stock {

	/** Fixed Dividend */
	private int fixedDividend = 0;

	/**
	 * Constructor
	 */
	public PreferredStock() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param symbol Stock Symbol
	 * @param type StockType
	 * @param lastDividend Last Dividend
	 * @param parValue Par Value
	 * @param fixedDividend Fixed Dividend
	 */
	public PreferredStock(String symbol, StockType type, int lastDividend, int parValue, int fixedDividend) {
		super(symbol, type, lastDividend, parValue);
		this.fixedDividend = fixedDividend;
	}

	/**
	 * Getter for Fixed Dividend
	 * 
	 * @return the fixed dividend
	 */
	public int getFixedDividend() {
		return fixedDividend;
	}

	/**
	 * Setter for Fixed Dividend
	 * 
	 * @param fixedDividend
	 */
	public void setFixedDividend(int fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	/**
	 * Represents the Stock
	 */
	@Override
	public String toString() {
		return "Prefered Stock [symbol=" + getSymbol() + ", type=" + getType() + "]";
	}

}
