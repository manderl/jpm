/**
 * 
 */
package com.jpm.main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.jpm.calculator.DividendYieldCalculator;
import com.jpm.calculator.GbceIndexCalculator;
import com.jpm.calculator.ReRatioCalculator;
import com.jpm.calculator.StockPriceCalculator;
import com.jpm.model.Index;
import com.jpm.model.PreferredStock;
import com.jpm.model.Price;
import com.jpm.model.Stock;
import com.jpm.model.Stock.StockType;
import com.jpm.model.Trade;
import com.jpm.model.Trade.TradeTypeIndicator;

/**
 * Main Class
 * 
 * @author MA
 *
 */
public class Test implements PropertyChangeListener {

	Logger logger = Logger.getLogger("Test");

	/** Property Name for ChangeListener */
	private static final String RECORD_TRADE = "recordTrade";
	/** Stock List */
	private final List<Index> indices = new ArrayList<Index>();
	/** Prices */
	private final List<Price> prices = new ArrayList<Price>();
	/** Map of all trades */
	private final Map<Stock, List<Trade>> tradeMap = new HashMap<Stock, List<Trade>>();
	/** Property Change Support */
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	/**
	 * Constructor
	 */
	public Test() {
		pcs.addPropertyChangeListener(this);
	}

	/**
	 * Calculates all figures
	 * 
	 * @param stock Stock which figures need to be calculated
	 */
	public void calculate(Stock stock) {

		System.out.println("Prices will be calculated");

		double stockPrice = StockPriceCalculator.calculate(tradeMap.get(stock));
		double dividendYield = DividendYieldCalculator.calculate(stock, stockPrice);
		double peRatio = ReRatioCalculator.calculate(stock, stockPrice);
		createPrice(stock, stockPrice, dividendYield, peRatio);

		double indexPrice = GbceIndexCalculator.calculate(prices);
		createIndex(indexPrice);
	}

	/**
	 * Creates the current price of a share
	 * 
	 * @param stock Stock
	 * @param stockPrice Stockprice
	 * @param dividendYield Dividend Yield
	 * @param peRatio P/E Ratio
	 */
	private void createPrice(Stock stock, double stockPrice, double dividendYield, double peRatio) {
		final Price price = new Price(stock, stockPrice, dividendYield, peRatio);
		prices.add(price);
	}

	/**
	 * Creates the current value of the GBCE All Share Index
	 * 
	 * @param indexPrice Calculated price on the index
	 */
	private void createIndex(double indexPrice) {
		Index index = new Index(indexPrice);
		indices.add(index);
	}

	/**
	 * Records the trade
	 * 
	 * @param trade latest trade
	 */
	public void recordTrade(Trade trade) {

		System.out.println("Trade will be recorded");

		// If stock does not exist, create a new record in the tradeMap
		if (!tradeMap.containsKey(trade.getStock())) {

			List<Trade> tradesOfStock = new ArrayList<Trade>();
			tradesOfStock.add(trade);
			tradeMap.put(trade.getStock(), tradesOfStock);

		} else {
			tradeMap.get(trade.getStock()).add(trade);
		}

		pcs.firePropertyChange(RECORD_TRADE, null, trade.getStock());
	}

	/**
	 * Creates a Report
	 */
	public void printReport() {

		Collection<List<Trade>> list = tradeMap.values();

		Iterator<List<Trade>> it = list.iterator();

		System.out.println("Received Trades:");
		while (it.hasNext()) {
			List<Trade> trades = it.next();

			for (Trade trade : trades) {
				System.out.println(trade.toString());
			}
		}

		System.out.println("Calculated Prices:");
		for (Price price : prices) {
			System.out.println(price.toString());
		}

		System.out.println("GBCE  All Share Index:");
		for (Index index : indices) {
			System.out.println(index.toString());
		}
	}

	/**
	 * Property Change Support
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (RECORD_TRADE.equals(evt.getPropertyName())) {

			if (evt.getNewValue() instanceof Stock) {
				calculate((Stock) evt.getNewValue());
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(new Stock("TEA", StockType.COMMON, 0, 100));
		stocks.add(new Stock("POP", StockType.COMMON, 8, 100));
		stocks.add(new Stock("ALE", StockType.COMMON, 23, 60));
		stocks.add(new PreferredStock("GIN", StockType.PREFERRED, 8, 100, 2));
		stocks.add(new Stock("JOE", StockType.COMMON, 13, 250));

		final List<Trade> trades = new ArrayList<Trade>();

		trades.add(new Trade(stocks.get(2), new Date(), 150, TradeTypeIndicator.BUY, 218.5));
		trades.add(new Trade(stocks.get(0), new Date(), 100, TradeTypeIndicator.BUY, 32.95));
		trades.add(new Trade(stocks.get(4), new Date(), 100, TradeTypeIndicator.SELL, 68.5));
		trades.add(new Trade(stocks.get(0), new Date(), 100, TradeTypeIndicator.BUY, 32.85));

		trades.add(new Trade(stocks.get(0), new Date(), 20, TradeTypeIndicator.SELL, 34.0));
		trades.add(new Trade(stocks.get(4), new Date(), 80, TradeTypeIndicator.BUY, 62.35));
		trades.add(new Trade(stocks.get(0), new Date(), 50, TradeTypeIndicator.SELL, 35.0));
		trades.add(new Trade(stocks.get(3), new Date(), 100, TradeTypeIndicator.BUY, 101.10));
		trades.add(new Trade(stocks.get(1), new Date(), 50, TradeTypeIndicator.SELL, 12.17));
		trades.add(new Trade(stocks.get(1), new Date(), 20, TradeTypeIndicator.SELL, 12.09));
		trades.add(new Trade(stocks.get(2), new Date(), 300, TradeTypeIndicator.BUY, 215.0));

		trades.add(new Trade(stocks.get(2), new Date(), 150, TradeTypeIndicator.BUY, 220.0));

		;
		trades.add(new Trade(stocks.get(4), new Date(), 50, TradeTypeIndicator.BUY, 58.34));
		trades.add(new Trade(stocks.get(3), new Date(), 20, TradeTypeIndicator.SELL, 102.10));
		trades.add(new Trade(stocks.get(1), new Date(), 200, TradeTypeIndicator.BUY, 12.22));
		trades.add(new Trade(stocks.get(3), new Date(), 20, TradeTypeIndicator.BUY, 99.3));
		trades.add(new Trade(stocks.get(3), new Date(), 50, TradeTypeIndicator.BUY, 96.60));
		trades.add(new Trade(stocks.get(0), new Date(), 10, TradeTypeIndicator.SELL, 33.80));
		trades.add(new Trade(stocks.get(4), new Date(), 40, TradeTypeIndicator.BUY, 56.12));
		trades.add(new Trade(stocks.get(1), new Date(), 60, TradeTypeIndicator.BUY, 12.13));
		trades.add(new Trade(stocks.get(4), new Date(), 10, TradeTypeIndicator.BUY, 59.70));

		trades.add(new Trade(stocks.get(1), new Date(), 60, TradeTypeIndicator.BUY, 12.16));
		trades.add(new Trade(stocks.get(4), new Date(), 5, TradeTypeIndicator.SELL, 65.60));

		Test t = new Test();

		for (int i = 0; i < 23; i++) {

			t.recordTrade(trades.get(i));

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		t.printReport();

	}
}
