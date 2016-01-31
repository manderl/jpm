package com.jpm.model;

/**
 * Stock represents a single Stock
 * 
 * @author MA
 */
public class Stock {

	/**
	 * Stock Type. Can either be Common or Preferred Used to calculate the
	 * dividend yield
	 */
	public enum StockType {
		COMMON, PREFERRED;
	};

	/** Stock Symbol */
	private String symbol;
	/** Stock Type {Common, Preferred} */
	private StockType type;
	/** Last Dividend, Fixed Dividend */
	private int lastDividend;
	/** Par Value */
	private int parValue;

	/**
	 * Constructor
	 */
	public Stock() {

	}

	/**
	 * Constructor
	 * 
	 * @param symbol Stock Symbol
	 * @param type StockType
	 * @param lastDividend Last Dividend
	 * @param parValue Par Value
	 */
	public Stock(String symbol, StockType type, int lastDividend, int parValue) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.parValue = parValue;
	}

	/**
	 * Getter Stock Symbol
	 * 
	 * @return Symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Setter Stock Symbol
	 * 
	 * @param symbol Symbol of a Stock
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Getter Stock Type
	 * 
	 * @return is either Common or Preferred
	 */
	public StockType getType() {
		return type;
	}

	/**
	 * Setter of the Stock Type
	 * 
	 * @param type StockType
	 */
	public void setType(StockType type) {
		this.type = type;
	}

	/**
	 * Getter Last Dividend (Unit: Pence)
	 * 
	 * @return returns the last dividend
	 */
	public int getLastDividend() {
		return lastDividend;
	}

	/**
	 * Setter for Dividend (Unit: Pence)
	 * 
	 * @param dividend Last Dividend
	 */
	public void setLastDividend(int dividend) {
		this.lastDividend = dividend;
	}

	/**
	 * Getter for Par Value (Unit: Pence)
	 * 
	 * @return Par Value
	 */
	public int getParValue() {
		return parValue;
	}

	/**
	 * Setter for Par Value (Unit: Pence)
	 * 
	 * @param parValue
	 */
	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

	/**
	 * Hash Code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/**
	 * Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	/**
	 * Represents the Stock
	 */
	@Override
	public String toString() {
		return "Common Stock [symbol=" + symbol + ", type=" + type + "]";
	}

}
