package com.jpm.model;

import java.util.Date;

/**
 * Represents a single Trade
 * 
 * @author MA
 *
 */
public class Trade {

	/** Trade Indicator, can either be BUY or SELL */
	public enum TradeTypeIndicator {
		BUY, SELL;
	};

	/** Stock Information */
	private Stock stock;
	/** Timestamp */
	private Date timestamp = new Date();
	/** Quantity of Stocks */
	private int quantity;
	/** Type Type Indicator */
	private TradeTypeIndicator tradeTypeIndicator;
	/** Price */
	private double price;

	/**
	 * Constructor
	 */
	public Trade() {
	}

	/**
	 * Constructor
	 * 
	 * @param stock Stock which is bought or sold
	 * @param timestamp Timestamp of the trade
	 * @param quantity quantity of traded instruments
	 * @param tradeTypeIndicator Trade Indicator, can either be BUY or SELL
	 * @param price Price of a single stock
	 */
	public Trade(Stock stock, Date timestamp, int quantity, TradeTypeIndicator tradeTypeIndicator, double price) {
		super();
		this.stock = stock;
		this.timestamp = timestamp;
		this.quantity = quantity;
		this.tradeTypeIndicator = tradeTypeIndicator;
		this.price = price;
	}

	/**
	 * Getter for Stock
	 * 
	 * @return Stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * Setter for Stock
	 * 
	 * @param stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * Getter for Timestamp
	 * 
	 * @return Timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Setter for Timestamp
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Getter for Quantity
	 * 
	 * @return Quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter for Quantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Getter for Trade Type Indicator
	 * 
	 * @return either BUY or SELL
	 */
	public TradeTypeIndicator getTradeTypeIndicator() {
		return tradeTypeIndicator;
	}

	/**
	 * Sets the Trade Type Indicator
	 * 
	 * @param tradeTypeIndicator BUY or SELL
	 */
	public void setTradeTypeIndicator(TradeTypeIndicator tradeTypeIndicator) {
		this.tradeTypeIndicator = tradeTypeIndicator;
	}

	/**
	 * Getter for the traded Price of a single stock
	 * 
	 * @return Price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for the traded Price of a single stock
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Hash Code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		Trade other = (Trade) obj;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	/**
	 * Shows basic data of this bean
	 */
	@Override
	public String toString() {
		return "Trade [Stock: Symbol:" + getStock().getSymbol() + ", timestamp=" + timestamp + ", tradeTypeIndicator="
		        + tradeTypeIndicator + "]";
	}

}
