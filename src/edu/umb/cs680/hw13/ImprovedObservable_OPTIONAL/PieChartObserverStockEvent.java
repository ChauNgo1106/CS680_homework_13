package edu.umb.cs680.hw13.ImprovedObservable_OPTIONAL;

public class PieChartObserverStockEvent<StockEvent> implements CustomObserver<StockEvent> {

	private CustomObservable<StockEvent> observable;

	public PieChartObserverStockEvent(CustomObservable<StockEvent> observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(CustomObservable<StockEvent> o, StockEvent arg) {
		StockQuoteCustomObservable temp = (StockQuoteCustomObservable) o;
		temp.printStockPrice();
		System.out.println("***********************Drawing Pie Chart for Stock Quote*********************** ");
	}

}
