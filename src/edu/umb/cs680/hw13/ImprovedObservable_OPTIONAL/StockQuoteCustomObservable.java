package edu.umb.cs680.hw13.ImprovedObservable_OPTIONAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import edu.umb.cs680.hw13.Multicast.StockQuoteObserver;

public class StockQuoteCustomObservable implements CustomObservable<StockEvent> {

	public ArrayList<CustomObserver<StockEvent>> observers;

	private HashMap<String, Float> map;

	public StockQuoteCustomObservable() {
		observers = new ArrayList<>();
		this.map = new HashMap<String, Float>();
	}
	
	public void changeQuote(String ticker, float quote) {
		map.replace(ticker, quote);
		notifyObserver(new StockEvent(ticker, quote));
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

	@Override
	public void addObserver(CustomObserver<StockEvent> o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(CustomObserver<StockEvent> o) {
		int index = observers.indexOf(o);
		// index of ArrayList starts at 0
		System.out.println("Observer at: " + (index + 1) + " is deleted");
		observers.remove(index);
		
	}

	@Override
	public void notifyObserver(StockEvent event) {
		for (CustomObserver<StockEvent> o : observers) {
			o.update(this, event);
		}
	}

}
