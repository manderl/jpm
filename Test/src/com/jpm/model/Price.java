/**
 * 
 */
package com.jpm.model;

import java.util.Date;

/**
 * Represents a singe Stock, latest Price and Metrics
 * 
 * @author MA
 *
 */
public class Price {

	/** Stock Information */
	private Stock stock;
	/** Timestamp */
	private Date timestamp = new Date();
	/** Price */
	private double price;
	/** Dividend Yield */
	private double dividendYield;
	/** P/E Ratio */
	private double peRatio;

	/**
	 * Constructor
	 */
	public Price() {
	}

	public Price(Stock stock, double price, double dividendYield, double peRatio) {
		super();
		this.stock = stock;
		this.price = price;
		this.dividendYield = dividendYield;
		this.peRatio = peRatio;
	}

	/**
	 * Constructor
	 * 
	 * @param stock Stock
	 */
	public Price(Stock stock) {
		this();
		this.stock = stock;
	}

	/**
	 * Getter for Stock
	 * 
	 * @return the Stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * Setter for Stock
	 * 
	 * @param stock Stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * Getter for Timestamp
	 * 
	 * @return the Timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Setter for Timestamp
	 * 
	 * @param timestamp Timestamps
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Getter for Price. Returns a price of a stock for a specific time
	 * 
	 * @return Price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for Price. Sets a price for a spezific time
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Getter for Dividend Yield. Returns a Dividend Yield for a specific time
	 * 
	 * @return Dividend Yield
	 */
	public double getDividendYield() {
		return dividendYield;
	}

	/**
	 * Sets the Dividend Yield for a specific time
	 * 
	 * @param dividendYield
	 */
	public void setDividendYield(double dividendYield) {
		this.dividendYield = dividendYield;
	}

	/**
	 * Getter for P/E Ratio. Returns a P/E Ratio of a stock at a specific time
	 * 
	 * @return P/E Ratio
	 */
	public double getPeRatio() {
		return peRatio;
	}

	/**
	 * Sets the P/E Ratio for a specific time
	 * 
	 * @param peRatio
	 */
	public void setPeRatio(double peRatio) {
		this.peRatio = peRatio;
	}

	/**
	 * Hash Code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Price other = (Price) obj;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Price [Stock=" + stock.getSymbol() + "timestamp=" + timestamp + ", price=" + price + ", dividendYield="
		        + dividendYield + ", peRatio=" + peRatio + "]";
	}

}
