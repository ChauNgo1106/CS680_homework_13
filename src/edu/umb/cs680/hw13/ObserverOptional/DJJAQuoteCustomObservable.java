package edu.umb.cs680.hw13.ObserverOptional;

import java.util.ArrayList;

public class DJJAQuoteCustomObservable implements CustomObservable {
	ArrayList<CustomObserver> observers;
	private float quote;
	public DJJAQuoteCustomObservable() {
		observers = new ArrayList<>();
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
	public void changeQuote(float quote) {
		this.quote = quote;
		notifyObserver(new DJJAEvent(quote));
	}
	
	public void printQuote() {
		System.out.println("Quote: " + this.quote);
	}

	
	


}
