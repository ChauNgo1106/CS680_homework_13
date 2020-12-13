package edu.umb.cs680.hw13.ObserverOptional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class StockQuoteCustomObservable implements CustomObservable {

	public ArrayList<CustomObserver> observers;

	private HashMap<String, Float> map;

	public StockQuoteCustomObservable() {
		observers = new ArrayList<>();
		this.map = new HashMap<String, Float>();
	}

	@Override
	public void addObserver(CustomObserver o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(CustomObserver o) {
		int index = observers.indexOf(o);

		// index of ArrayList starts at 0
		System.out.println("Observer at: " + (index + 1) + " is deleted");
		observers.remove(index);

	}

	@Override
	public void notifyObserver(Object arg) {
		for (CustomObserver o : observers) {
			o.update(this, arg);
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
