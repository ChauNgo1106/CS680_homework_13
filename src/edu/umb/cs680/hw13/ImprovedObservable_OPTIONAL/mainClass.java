package edu.umb.cs680.hw13.ImprovedObservable_OPTIONAL;

public class mainClass {

	public static void main(String[] args) {
		StockQuoteCustomObservable so = new StockQuoteCustomObservable();
		PieChartObserverStockEvent<StockEvent> po = new PieChartObserverStockEvent<StockEvent>(so);

		so.addStock("IBM", 199.12F);
		so.addStock("Google", 249.48F);
		so.addStock("Facebook", 341.21F);

		so.changeQuote("IBM", 133.45F);
		so.changeQuote("IBM", 154.45F);
		so.changeQuote("Google", 244.19F);

		DJJAQuoteCustomObservable djja = new DJJAQuoteCustomObservable();

		PieChartObserverDJJAEvent po1 = new PieChartObserverDJJAEvent(djja);

		djja.changeQuote(3.42F);
		djja.changeQuote(10.21F);
	}

}
