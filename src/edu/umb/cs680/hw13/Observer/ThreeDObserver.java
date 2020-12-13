package edu.umb.cs680.hw13.Observer;

import java.util.Observable;
import java.util.Observer;

public class ThreeDObserver implements Observer {

	private Observable ob;

	public ThreeDObserver(Observable o) {
		this.ob = o;
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof StockEvent) {
			StockQuoteObservable temp = (StockQuoteObservable) o;
			temp.printStockPrice();
			System.out.println("***********************Drawing 3D*********************** ");
		} else if (arg instanceof DJJAEvent) {
			DJJAQuoteObservable temp = (DJJAQuoteObservable) o;
			temp.printQuote();
			System.out.println("***********************Drawing 3D*********************** ");
		}

	}

}
