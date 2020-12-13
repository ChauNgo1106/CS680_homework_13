package edu.umb.cs680.hw13.ObserverOptional;

public class PieChartObserver implements CustomObserver {

	private CustomObservable observable;

	public PieChartObserver(CustomObservable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(CustomObservable o, Object arg) {
		if (arg instanceof StockEvent) {
			StockQuoteCustomObservable temp = (StockQuoteCustomObservable) o;
			temp.printStockPrice();
			System.out.println("***********************Drawing Pie Chart for Stock Quote*********************** ");
			
		} else if (arg instanceof DJJAEvent) {
			DJJAQuoteCustomObservable temp = (DJJAQuoteCustomObservable) o;
			temp.printQuote();
			System.out.println("***********************Drawing Pie Chart for DJJA*********************** ");
		}

	}

}
