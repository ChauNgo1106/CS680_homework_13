package edu.umb.cs680.hw13.Multicast;

import java.util.ArrayList;
import java.util.HashMap;

public class StockQuoteObservable {

	ArrayList<StockQuoteObserver> observers;
	private HashMap<String, Float> map;

	public StockQuoteObservable() {
		observers = new ArrayList<>();
		map = new HashMap<String, Float>();
	}

	public void addObserver(StockQuoteObserver o) {
		observers.add(o);

	}

	public void removeObserver(StockQuoteObserver o) {
		int index = observers.indexOf(o);
		// index of ArrayList starts at 0
		System.out.println("Observer at: " + (index + 1) + " is deleted");
		observers.remove(index);
	}

	public void notifyObserver(StockEvent arg) {
		for (StockQuoteObserver o : observers) {
			o.updateStock(arg);
		}

	}

	public void changeQuote(String ticker, float quote) {
		map.replace(ticker, quote);
		StockEvent temp = new StockEvent(ticker, quote);
		notifyObserver(temp);
	}

	public void printStockPrice() {
		for (String key : map.keySet()) {
			System.out.println("Stock(" + key + ") Price: " + map.get(key));
		}
	}

	public void addStock(String ticker, float quote) {
		this.map.put(ticker, quote);
	}

	public HashMap<String, Float> getMap() {
		return map;
	}

}
