package edu.umb.cs680.hw13.ImprovedObservable_OPTIONAL;

import java.util.ArrayList;

public class DJJAQuoteCustomObservable implements CustomObservable<DJJAEvent> {
	ArrayList<CustomObserver<DJJAEvent>> observers;
	private float quote;
	public DJJAQuoteCustomObservable() {
		observers = new ArrayList<>();
	}

	@Override
	public void addObserver(CustomObserver<DJJAEvent> o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(CustomObserver<DJJAEvent> o) {
		int index = observers.indexOf(o);
		// index of ArrayList starts at 0
		System.out.println("Observer at: " + (index + 1) + " is deleted");
		observers.remove(index);
		
	}

	@Override
	public void notifyObserver(DJJAEvent event) {
		for (CustomObserver<DJJAEvent> o : observers) {
			o.update(this, event);
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
