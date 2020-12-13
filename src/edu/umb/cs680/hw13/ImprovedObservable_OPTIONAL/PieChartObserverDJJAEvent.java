package edu.umb.cs680.hw13.ImprovedObservable_OPTIONAL;

public class PieChartObserverDJJAEvent implements CustomObserver<DJJAEvent> {

	private CustomObservable<DJJAEvent> observable;

	public PieChartObserverDJJAEvent(CustomObservable<DJJAEvent> observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(CustomObservable<DJJAEvent> o, DJJAEvent arg) {
		DJJAQuoteCustomObservable temp = (DJJAQuoteCustomObservable) o;
		temp.printQuote();
		System.out.println("***********************Drawing Pie Chart for DJJA*********************** ");
	}


}
