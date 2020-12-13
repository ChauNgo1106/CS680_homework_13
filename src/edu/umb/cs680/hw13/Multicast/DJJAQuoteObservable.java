package edu.umb.cs680.hw13.Multicast;

import java.util.ArrayList;

public class DJJAQuoteObservable {
	
	ArrayList<DJJAQuoteObserver> observers;
	
	private float quote;
	
	public DJJAQuoteObservable() {
		observers = new ArrayList<>();
	}

	public void addObserver(DJJAQuoteObserver o) {
		observers.add(o);

	}

	public void removeObserver(DJJAQuoteObserver o) {
		int index = observers.indexOf(o);

		// index of ArrayList starts at 0
		System.out.println("Observer at: " + (index + 1) + " is deleted");
		observers.remove(index);

	}
	
	public void notifyObserver(DJJAEvent arg) {
		for (DJJAQuoteObserver o : observers) {
			o.updateDJJA(arg);
		}

	}
	
	public void changeQuote(float quote) {
		this.quote = quote;
		notifyObserver(new DJJAEvent(quote));
	}
	
	public void printQuote() {
		System.out.println("Quote: " + this.quote);
	}
	public float getQuote() {
		return this.quote;
	}


}
