package edu.umb.cs680.hw13.Observer;

import java.util.*;

public class StockQuoteObservable extends Observable {

	private HashMap<String , Float > map; 
	
	public StockQuoteObservable() {
		this.map = new HashMap<String, Float>();
	}
	
	public void printStockPrice() {
		for(String key : map.keySet()) {
			System.out.println("Stock(" + key + ") Price: " + map.get(key));
		}
	}
	public void addStock(String ticker, float quote) {
		this.map.put(ticker, quote);
	}
	
 	public HashMap<String, Float> getMap() {
		return map;
	}

	public void changeQuote(String t, float q) {
 		//update map, if can not find the key t ==> throw an error or print out message
 		//key is ticker and value is quote. 
 		map.replace(t, q);
		setChanged();
		notifyObservers(new StockEvent(t, q));
	}

}
