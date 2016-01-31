package com.jpm.model;

import java.util.Date;

/**
 * Represents a single Index Bean
 * 
 * @author MA
 *
 */
public class Index {

	/** Timestamp of calculation */
	private Date timestamp = new Date();
	/** Calculated Price */
	private double price;

	/**
	 * Constructor
	 */
	public Index() {
	}

	/**
	 * Constructor
	 * 
	 * @param price
	 */
	public Index(double price) {
		super();
		this.price = price;
	}

	/**
	 * Constructor
	 * 
	 * @param timestamp
	 * @param price
	 */
	public Index(Date timestamp, double price) {
		super();
		this.timestamp = timestamp;
		this.price = price;
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
	 * Getter for calculated Price
	 * 
	 * @return Price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for calculated Price
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
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Index other = (Index) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	/**
	 * Retrieves Information about the Index
	 */
	@Override
	public String toString() {
		return "Index [timestamp=" + timestamp + ", price=" + price + "]";
	}

}
