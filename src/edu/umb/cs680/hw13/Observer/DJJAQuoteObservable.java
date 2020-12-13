package edu.umb.cs680.hw13.Observer;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class DJJAQuoteObservable extends Observable {
	private float quote;
	
	public DJJAQuoteObservable(float quote) {
		this.quote = quote;
	}
	
	public void changeQuote(float q) {
		this.quote = q;
		setChanged();
		notifyObservers(new DJJAEvent(quote));
	}
	
	public float getQuote() {
		return quote;
	}

	public void printQuote() {
		System.out.println("Quote: " + this.quote);
	}


}
